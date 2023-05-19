import java.awt.Graphics;

public class Enemy extends Creature {
	
	private Game game;
	private int radius = height / 2;
	private int lower = 3;
	private int upper = 7;;
	public Enemy(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		speed = (int) ((Math.random() * ((upper - lower) + 1)) + lower);
	}

	//renders enemy
	public void render(Graphics g) {
		g.drawImage(Assets.monster1, (int) x, (int) y, width, height, null);
	}

	//enemy movement
	public void tick() {
		yMovement = speed;
		move();
	}
	
	//makes sure enemies spawn in the right places
	public void checkBounds(Enemy e, int newx, Game game) {
		if (e.y > 1000) {
			e.setX((int) (Math.random() * 936));
			e.setY(-50);
			e.speed = (int) ((Math.random() * ((upper - lower) + 1)) + lower);
		}
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getUpper() {
		return upper;
	}
	
	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public int getLower() {
		return lower;
	}
	
	public void setLower(int lower) {
		this.lower = lower;
	}

}
