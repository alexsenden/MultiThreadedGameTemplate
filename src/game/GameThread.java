package game;

public class GameThread extends Thread {
	
	private static final int TPS = 60;
	private static final long SECOND_IN_NANOS = 1000000000;
	
	private Game game;
	
	public GameThread(Game game) {
		this.game = game;
		initializeObjects();
	}
	
	// Starts the thread, runs tick ~TPS times per second
	@Override
	public void run() {
		long lastFrameTime = System.nanoTime();
		long currentTime;
		
		while(game.isActive()) {
			currentTime = System.nanoTime();
			if(currentTime - lastFrameTime > SECOND_IN_NANOS / (double)TPS) {
				tick();
			}
		}
	}
	
	// Ticks all objects
	public void tick() {
		for(GameObject o : game.getObjects()) {
			o.tick();
		}
		game.tick();
	}
	
	// Add objects that will exist at startup
	public void initializeObjects() {
		
	}
}
