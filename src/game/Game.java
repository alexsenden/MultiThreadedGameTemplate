package game;

import java.util.ArrayList;

public class Game {
	
	private volatile boolean active;
	
	private GameState state;
	
	private static final String[] audioStrings = new String[] {};
	private int songIndex;
	
	private volatile ArrayList<GameObject> objects;
	
	public Game() {
		active = true;
		objects = new ArrayList<GameObject>();
		state = GameState.RUNNING;
	}
	
	public void tick() {
		
	}
	
	public ArrayList<GameObject> getObjects(){
		return objects;
	}
	
	public void addObject(GameObject o) {
		objects.add(o);
	}
	
	public void removeObject(GameObject o) {
		objects.remove(o);
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public GameState getState() {
		return state;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public String getCurrentAudioName() {
		return audioStrings[songIndex];
	}
	
	public String getAudioName(int index) {
		return audioStrings[index];
	}
	
	public void setSongIndex(int index) {
		songIndex = index;
	}
}
