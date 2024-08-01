package examples;

import com.raylib.java.Config;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Keyboard;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.utils.Tracelog;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class KeyboardInput {
	public static final int WINDOW_HEIGHT = 1000;
	public static final int WINDOW_WIDTH  = 1920;
	
	public static void main(String[] args) {
		Raylib rl = new Raylib();
		rl.core.SetConfigFlags(Config.ConfigFlag.FLAG_WINDOW_RESIZABLE);
		Tracelog.SetTraceLogLevel(Tracelog.TracelogType.LOG_ALL);
		rl.core.InitWindow(WINDOW_WIDTH , WINDOW_HEIGHT , "Basic Window");
		rl.core.SetTargetFPS(60);
		ArrayList<Ball> balls = new ArrayList<>();
		
		while (! rl.core.WindowShouldClose()) {
			rl.core.BeginDrawing();
			//////////////////////
			rl.core.ClearBackground(Color.DARKBLUE);
			
			for (Ball ball : balls) {
				ball.draw();
			}
			if (rl.core.IsKeyPressed(Keyboard.KEY_D)) {
				Ball redBall = new Ball(Color.RED , rl);
				balls.add(redBall);
			}
			//////////////////////
			rl.core.EndDrawing();
		}
		rl.core.CloseWindow();
	}
	
	static class Ball {
		public  Vector2 position;
		public  float   radius;
		public  Color   color;
		private Raylib  rl_ctx = null;
		
		public Ball(Color color , Vector2 position , float radius , Raylib rl_ctx) {
			this.color    = color;
			this.position = position;
			this.radius   = radius;
			this.rl_ctx   = rl_ctx;
		}
		
		public Ball(Color color , float radius , Raylib rl_ctx) {
			
			this(Color.RED , new Vector2(ThreadLocalRandom.current().nextInt(0 , WINDOW_WIDTH - 20) ,
			                             ThreadLocalRandom.current().nextInt(0 , WINDOW_HEIGHT - 20)) , radius , rl_ctx);
		}
		
		public Ball(Color color , Raylib rl_ctx) {
			
			this(Color.RED , new Vector2(ThreadLocalRandom.current().nextInt(0 , WINDOW_WIDTH) ,
			                             ThreadLocalRandom.current().nextInt(0 , WINDOW_HEIGHT)) ,
			     ThreadLocalRandom.current().nextFloat(30 , 100) , rl_ctx);
		}
		
		public Ball(Vector2 position , float radius , Raylib rl_ctx) {
			this(Color.RED , position , radius , rl_ctx);
		}
		
		public void draw() {
			if (this.rl_ctx == null) {
				throw new IllegalStateException("Ball has no Raylib context");
			}
			
			this.rl_ctx.shapes.DrawCircleV(this.position , this.radius , this.color);
		}
	}
	
}