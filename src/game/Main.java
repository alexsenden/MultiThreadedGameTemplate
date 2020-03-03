package game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		
		GraphicsThread graphicsThread = new GraphicsThread(game);
		GameThread gameThread = new GameThread(game);
		AudioThread audioThread = new AudioThread(game);
		
		graphicsThread.start();
		gameThread.start();
		audioThread.start();
	}
}
