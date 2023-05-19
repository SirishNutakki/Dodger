import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RetryState extends State {
	
	//creates retry screen
	public RetryState(Game game) {
		super(game);
	}

	//allows r to restart 
	public void tick() {
		if(game.getKeyManager().restart) {
			StateChanger.setState(game.game1);
		}
		
	}

	//renders retry screen
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, game.width, game.height);
		g.setColor(Color.black);
		Font f = new Font("TimesRoman", Font.BOLD, 60);
		g.setFont(f);
		g.drawString("Score: " + game.points, 360, 280);
		g.drawString("Press 'r' to Restart", 250, 430);
	}

}
