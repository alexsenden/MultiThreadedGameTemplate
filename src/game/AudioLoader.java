package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioLoader {
	public static Clip getAudioStream(String path) {
		AudioInputStream audioInputStream = null;
		Clip clip = null;
		
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		try {
			clip.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		return clip;
	}
}
