package utils;

import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import java.util.concurrent.ThreadLocalRandom;

public class Ball {
	public              Vector2       position;
	public              float         radius;
	public              Color         color;
	private             RaylibContext rl_ctx = null;
	public static final Color[]       colors = new Color[]{ Color.BROWN , Color.RED , Color.BLACK , Color.BLUE , Color.GREEN };
	
	static {
		for (Color _color : colors) {
			_color.setA(0x99);
		}
		
	}
	
	
	public Ball(Color color , Vector2 position , float radius , RaylibContext rl_ctx) {
		this.color    = color;
		this.position = position;
		this.radius   = radius;
		this.rl_ctx   = rl_ctx;
	}
	
	public Ball(Color color , float radius , RaylibContext rl_ctx) {
		
		this(Color.RED , new Vector2(ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_WIDTH - 20) ,
		                             ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_HEIGHT - 20)) , radius , rl_ctx);
	}
	
	public Ball(Color color , RaylibContext rl_ctx) {
		
		this(Color.RED , new Vector2(ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_WIDTH) ,
		                             ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_HEIGHT)) ,
		     ThreadLocalRandom.current().nextFloat(30 , 100) , rl_ctx);
	}
	
	public Ball(RaylibContext rl_ctx) {
		
		this(colors[ThreadLocalRandom.current().nextInt(colors.length)] ,
		     new Vector2(ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_WIDTH) ,
		                 ThreadLocalRandom.current().nextInt(0 , rl_ctx.WINDOW_HEIGHT)) , ThreadLocalRandom.current().nextFloat(30 , 100) ,
		     rl_ctx);
	}
	
	public Ball(Vector2 position , float radius , RaylibContext rl_ctx) {
		this(Color.RED , position , radius , rl_ctx);
	}
	
	public void draw() {
		if (this.rl_ctx == null) {
			throw new IllegalStateException("Ball has no Raylib context");
		}
		
		this.rl_ctx.rl.shapes.DrawCircleV(this.position , this.radius , this.color);
	}
}