
public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 3;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMovement;
	protected float yMovement;
	
	//how a creature: player, enemy, should be made
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);	
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}
	
	//creature movement
	public void move() {
		x += xMovement;
		y += yMovement;
	}
	
	//getters and setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMovement() {
		return xMovement;
	}

	public void setxMovement(float xMovement) {
		this.xMovement = xMovement;
	}

	public float getyMovement() {
		return yMovement;
	}

	public void setyMovement(float yMovement) {
		this.yMovement = yMovement;
	}
	
	
}
