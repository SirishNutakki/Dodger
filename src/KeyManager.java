import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys;
	public boolean left, right, up, down;
	public boolean restart;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}
	//sets up keys used
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		restart = keys[KeyEvent.VK_R];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
