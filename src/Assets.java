
import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage monster1, player;
	
	//assets used in the game
	public static void init() {
		monster1 = ImageLoader.loader("C:\\Users\\Sirish\\eclipse-workspace\\Dodger\\resources\\textures\\monster1.png");
		player = ImageLoader.loader("C:\\Users\\Sirish\\eclipse-workspace\\Dodger\\resources\\textures\\Joy.png");
		
	}
}
