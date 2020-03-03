package game;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsThread extends Thread {
	
	private static final int HEIGHT = 450;
	private static final int WIDTH = 600;
	private static final int FPS = 60;
	private static final long SECOND_IN_NANOS = 1000000000;
	
	private static final String TITLE = "TITLE";
	
	private Game game;
	private Canvas canvas;
	private JFrame window;
	
	public GraphicsThread(Game game) {
		this.game = game;
		this.canvas = new Canvas();
		this.window = new JFrame(TITLE);
	}
	
	@Override
	public void run() {
		initializeWindow(window);
		window.setVisible(true);
		
		long lastFrameTime = System.nanoTime();
		long currentTime;
		
		while(game.isActive()) {
			currentTime = System.nanoTime();
			if(currentTime - lastFrameTime > SECOND_IN_NANOS / (double)FPS) {
				render();
			}
		}
	}
	
	public void initializeWindow(JFrame window) {
		int xOnScreen = 10;
		int yOnScreen = 10;
		
		window.setBounds(xOnScreen, yOnScreen, WIDTH, HEIGHT);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setFocusable(true);
		window.requestFocus();
		window.addKeyListener(new KBListeners());
		
		window.add(canvas);
	}
	
	public void render() {
		if(canvas.getBufferStrategy() == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g = canvas.getGraphics();
		
		for(GameObject o : game.getObjects()) {
			o.render(g);
		}
	}
}
