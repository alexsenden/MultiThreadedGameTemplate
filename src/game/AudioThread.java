package game;

import javax.sound.sampled.Clip;

public class AudioThread extends Thread {
	
	private static final int TPS = 60;
	private static final long SECOND_IN_NANOS = 1000000000;
	
	private Game game;
	
	private String playing;
	private Clip clip;
	
	// TODO: Get audio file from name
	public AudioThread(Game game) {
		this.game = game;
		playing = game.getCurrentAudioName();
		clip = AudioLoader.getAudioStream(playing); // TODO
	}
	
	// Starts the thread, runs tick ~TPS times per second
	@Override
	public void run() {
		
		clip.start();
		
		long lastFrameTime = System.nanoTime();
		long currentTime;
		
		while(game.isActive()) {
			currentTime = System.nanoTime();
			if(currentTime - lastFrameTime > SECOND_IN_NANOS / (double)TPS) {
				if(!playing.equals(game.getCurrentAudioName())){
					clip.stop();
					playing = game.getCurrentAudioName();
					clip = AudioLoader.getAudioStream(playing); // TODO
					clip.start();
				}
			}
		}
	}
}
