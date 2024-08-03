package examples;

import com.raylib.java.Config;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.utils.Tracelog;
import utils.Ball;
import utils.RaylibContext;

public class MouseControl {
	public static final int WINDOW_HEIGHT = 1020;
	public static final int WINDOW_WIDTH  = 1920;
	public static final int TARGET_FPS    = 60;
	
	public static void main(String[] args) {
		Raylib rl = new Raylib();
		rl.core.SetConfigFlags(Config.ConfigFlag.FLAG_WINDOW_RESIZABLE);
		Tracelog.SetTraceLogLevel(Tracelog.TracelogType.LOG_ALL);
		rl.core.InitWindow(WINDOW_WIDTH , WINDOW_HEIGHT , "Mouse Control");
		rl.core.SetTargetFPS(TARGET_FPS);
		RaylibContext rl_ctx = new RaylibContext(WINDOW_WIDTH , WINDOW_HEIGHT , TARGET_FPS , rl);
		while (! rl.core.WindowShouldClose()) {
			rl.core.BeginDrawing();
			////////////////////////
			
			rl.core.ClearBackground(Color.RAYWHITE);
			new Ball(rl.core.GetMousePosition() , 100 , rl_ctx).draw();
			
			////////////////////////
			rl.core.EndDrawing();
		}
		rl.core.CloseWindow();
	}
	
}