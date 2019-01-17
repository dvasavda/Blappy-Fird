package game;

import java.awt.Color;
import java.io.IOException;

import acm.graphics.GImage;
import acm.graphics.GObject;
import game.AudioPlayer;

public class MainApplication extends GraphicsApplication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WINDOW_HEIGHT = 535;
	public static final int WINDOW_WIDTH = 1000;
	public static final int BUTTON_HEIGHT = 250;
	public static final int BUTTON_WIDTH = 50;
	
	public static boolean isLobbySoundOn = true;
	public static boolean isGameSoundOn = true;

	private MenuPane menuPane;
	private StorePane storePane;
	private SettingsPane settingsPane;
	private GameTest gamePane;
	private Instructions instructions;
	private LeaderboardsPane leaderboardsPane;

	public static GImage background = new GImage("menu.png", 0, 0);

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menuPane = new MenuPane(this);
		storePane = new StorePane(this);
		settingsPane = new SettingsPane(this);
		gamePane = new GameTest(this);
		instructions = new Instructions(this);
		try {
			leaderboardsPane = new LeaderboardsPane(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToMenu();
	}

	public void switchToMenu() {
		AudioPlayer audio = AudioPlayer.getInstance();
		if (isLobbySoundOn) {
			audio.playSound("sounds", "menuBeat.wav");
		}
		switchToScreen(menuPane);
	}

	public void switchToStore() {
		switchToScreen(storePane);
	}

	public void switchToLeaderboards() {
		switchToScreen(leaderboardsPane);
	}
	
	public void switchToSettings() {
		switchToScreen(settingsPane);
	}
	
	public void switchToGame() {
		muteSound();
		switchToScreen(gamePane);
	}
	
	public void switchToInstructions() {
		switchToScreen(instructions);
	}
	
	public void muteSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound("sounds", "menuBeat.wav");
	}		
	
	public static void highlightsButton(GButton button, GObject obj, int r, int g, int b) {
		Color highlightColor = new Color(r, g, b);
		if (obj == button)
			button.setFillColor(highlightColor);
		else {
			if (r == 220)
				button.setFillColor(Color.RED);
			else {
				button.setFillColor(Color.GREEN);
			}
		}
	}
}
