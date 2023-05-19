import java.awt.Graphics;

public class Player extends Creature {
	
	private Game game;
	private int radius = width / 2;
	
	//creates player
	public Player(Game game, float x, float y) {
		super(x, y, 48, 48);
		health = 100;
		this.game = game;
	}

	//renders player
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

	//responds to player movement input
	public void tick() {
		Input();
		move();
	}
	
	//player movement
	private void Input() {
		xMovement = 0;
		yMovement = 0;
		
		if (game.getKeyManager().up && y > 0) {
			yMovement = -speed;
		}
		if (game.getKeyManager().down && y < 700 - height) {
			yMovement = speed;
		}
		if (game.getKeyManager().left && x > 0) {
			xMovement = -speed;
		}
		if (game.getKeyManager().right && x < 1000 - width) {
			xMovement = speed;
		}
	}
	
	//checks for collision with enemies
	public boolean checkEnemyCollision(Enemy e) {
		boolean result = false;
		double dx = x - e.getX();
		double dy = y - e.getY();
		result = dx * dx + dy * dy < (radius + e.getRadius()) * (radius + e.getRadius());
		return result;
	}
	
	//increases movement speed
	public void increaseSpeed(double inc) {
		speed += inc;
	}

}
