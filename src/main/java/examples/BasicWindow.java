package examples;

import com.raylib.java.Config;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Keyboard;
import com.raylib.java.utils.Tracelog;

public class BasicWindow {
	public static void main(String[] args) {
		Raylib rl = new Raylib();
		final int WINDOW_HEIGHT = 1000;
		final int WINDOW_WIDTH = 1920;
		rl.core.SetConfigFlags(Config.ConfigFlag.FLAG_WINDOW_RESIZABLE);
		Tracelog.SetTraceLogLevel(Tracelog.TracelogType.LOG_ALL);
		rl.core.InitWindow(WINDOW_WIDTH , WINDOW_HEIGHT , "Basic Window");
		while (! rl.core.WindowShouldClose()) {
			rl.core.BeginDrawing();
			rl.core.ClearBackground(Color.DARKBLUE);
			
			if (rl.core.IsKeyPressed(Keyboard.KEY_D)) {
				System.out.println("Hello");
			}
			rl.core.EndDrawing();
		}
		rl.core.CloseWindow();
	}
}