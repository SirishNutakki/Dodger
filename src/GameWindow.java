import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GameWindow {
	private JFrame window;
	private static Canvas canvas;
	
	private String name;
	private int width;
	private int height;
	
	//dimensions of window
	public GameWindow(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		createWindow();
	}
	
	//creates window
	private void createWindow() {
		window = new JFrame(name);
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		window.add(canvas);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public static Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return window;
	}
}
