import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {
	
	private Player player;
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Enemy enemy6;
	private Enemy enemy7;
	private Enemy enemy8;
	private Enemy enemy9;
	private Enemy enemy10;
	private Enemy enemy11;
	private Enemy enemy12;
	private Enemy enemy13;
	private Enemy enemy14;
	private Enemy enemy15;
	
	private int points;
	private int pointbaseline;
	
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	//adds player and enemies to the screen 
	public GameState(Game game) {
		super(game);
		player = new Player(game, 472, 472);
		enemy1 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy1);
		enemy2 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy2);
		enemy3 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy3);
		enemy4 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy4);
		enemy5 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy5);
		enemy6 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy6);
		enemy7 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy7);
		enemy8 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy8);
		enemy9 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy9);
		enemy10 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy10);
		enemy11 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy11);
		enemy12 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy12);
		enemy13 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy13);
		enemy14 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy14);
		enemy15 = new Enemy(game, (int) (Math.random() * 936), 0);
		enemyList.add(enemy15);
	}
	
	//allows for player and enemy movement
	public void tick() {
		player.tick();
		points++;
		if (points == pointbaseline + 500 && enemyList.get(0).getUpper() < 18) {
			for (int i = 0; i < enemyList.size(); i++) {
				enemyList.get(i).setUpper(enemyList.get(i).getUpper() + 1);
				enemyList.get(i).setLower(enemyList.get(i).getLower() + 1);
			}
			pointbaseline = points;
			player.increaseSpeed(0.5);
		}
		
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).tick();
			enemyList.get(i).checkBounds(enemyList.get(i), (int) (Math.random() * 1000), game);
			player.checkEnemyCollision(enemyList.get(i));
			if (player.checkEnemyCollision(enemyList.get(i)) == true) {
				player.setHealth(player.getHealth() - 1);
			}
		}
	}

	//renders players and enemies
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, game.width, game.height);
		
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		g.setColor(Color.black);
		g.setFont(f);
		g.drawString("Score: " + Integer.toString(points), 80, 50);
		g.drawString("Health: " + Integer.toString(player.getHealth()), 800, 50);
		player.render(g);
		
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).render(g);
		}
	}
	
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}
	
	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getPoints() {
		return points;
	}
}
