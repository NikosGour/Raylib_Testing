package examples;

import com.raylib.java.Config;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Keyboard;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.utils.Tracelog;
import utils.Ball;
import utils.RaylibContext;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Balls {
	public static final int WINDOW_HEIGHT = 1000;
	public static final int WINDOW_WIDTH  = 1920;
	public static final int TARGET_FPS    = 60;
	
	public static void main(String[] args) {
		Raylib rl = new Raylib();
		rl.core.SetConfigFlags(Config.ConfigFlag.FLAG_WINDOW_RESIZABLE);
		Tracelog.SetTraceLogLevel(Tracelog.TracelogType.LOG_ALL);
		rl.core.InitWindow(WINDOW_WIDTH , WINDOW_HEIGHT , "Balls");
		rl.core.SetTargetFPS(TARGET_FPS);
		RaylibContext rl_ctx = new RaylibContext(WINDOW_WIDTH , WINDOW_HEIGHT , TARGET_FPS , rl);
		ArrayList<Ball> balls = new ArrayList<>();
		
		int frameCounter = 0;
		while (! rl.core.WindowShouldClose()) {
			rl.core.BeginDrawing();
			//////////////////////
			rl.core.ClearBackground(Color.RAYWHITE);
			frameCounter++;
			if (frameCounter >= TARGET_FPS / 3) {
				Ball redBall = new Ball(rl_ctx);
				balls.add(redBall);
				frameCounter = 0;
			}
			
			for (Ball ball : balls) {
				ball.draw();
			}
			if (rl.core.IsKeyPressed(Keyboard.KEY_D)) {
				Ball redBall = new Ball(rl_ctx);
				balls.add(redBall);
			}
			//////////////////////
			rl.core.EndDrawing();
		}
		rl.core.CloseWindow();
	}
	
	
}