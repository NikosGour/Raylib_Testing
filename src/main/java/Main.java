import com.raylib.java.Raylib;
import com.raylib.java.core.Color;

public class Main {
	public static void main(String[] args) {
		Raylib rl = new Raylib();
		rl.core.InitWindow(800 , 600 , "Nikos");
		rl.core.SetTargetFPS(60);
		while (! rl.core.WindowShouldClose()) {
			rl.core.BeginDrawing();
			rl.core.ClearBackground(Color.BROWN);//new Color(0xFF , 0x0 , 0x0 , 0xFF));
			rl.core.EndDrawing();
		}
		
	}
}