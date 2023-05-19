
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
	
	private GameWindow window;
	
	public int width;
	public int height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public GameState game1;
	private RetryState retry;
	
	private KeyManager keys;
	public int points;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keys = new KeyManager();
	}
	
	//initializes elements needed for game
	private void initialize() {
		window = new GameWindow(title, width, height);
		window.getFrame().addKeyListener(keys);
		Assets.init();
		
		game1 = new GameState(this);
		retry = new RetryState(this);
		StateChanger.setState(game1);
	}
	
	//updates elements
	private void tick() {
		keys.tick();
		if(StateChanger.getState() != null) {
			StateChanger.getState().tick();
			
		}
	}
	
	//renders elements
	private void render() {
		bs = GameWindow.getCanvas().getBufferStrategy();
		if (bs == null) {
			GameWindow.getCanvas().createBufferStrategy(3); //adds 3 frame delay
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(StateChanger.getState() != null) {
			StateChanger.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	//runs the game
	public void run() {
		initialize();
		
		int fps = 60; //game runs at 60 frames per second
		double tickTime = 1000000000 / fps; //time in ns divided by frames per second
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			if (game1.getPlayer().getHealth() < 1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				points = game1.getPoints();
				StateChanger.setState(retry);
				game1 = new GameState(this);
				
			}
			now = System.nanoTime();
			delta += (now - lastTime) / tickTime;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("fps: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keys;
	}
	
	//starts game
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//stops game
	public synchronized void stop() {
		if (running == false) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
