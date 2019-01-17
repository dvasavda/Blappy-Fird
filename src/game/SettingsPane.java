package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class SettingsPane extends GraphicsPane {
	private MainApplication program;
	private GImage settingsImage = new GImage("settings.png", 0, 0);
	private GLabel settingsLabel = new GLabel("Settings", 300, 100);
	private GButton musicButton = new GButton("On", 140, 270, MainApplication.BUTTON_HEIGHT, MainApplication.BUTTON_WIDTH, Color.GREEN);
	private GButton sfxButton = new GButton("On", 550, 270, MainApplication.BUTTON_HEIGHT, MainApplication.BUTTON_WIDTH, Color.GREEN);
	private GLabel musicLabel = new GLabel("Lobby Music", 200, 240);
	private GLabel sfxLabel = new GLabel("Sound FX", 620, 240);
	
	public SettingsPane(MainApplication app) {
		this.program = app;
		setLabel();
	}

	@Override
	public void showContents() {
		program.add(settingsImage);
		program.add(settingsLabel);
		program.add(musicLabel);
		program.add(sfxLabel);
		program.add(musicButton);
		program.add(sfxButton);
	}

	@Override
	public void hideContents() {
		program.remove(settingsImage);
		program.remove(settingsLabel);
		program.remove(musicLabel);
		program.remove(musicButton);
		program.remove(sfxLabel);
		program.remove(sfxButton);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// On Escape press, goes back to menu screen
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == musicButton && MainApplication.isLobbySoundOn) {
			AudioPlayer audio = AudioPlayer.getInstance();
			audio.stopSound("sounds", "menuBeat.wav");
			musicButton.getLabel().setLabel("Off");
			MainApplication.isLobbySoundOn = false;
		} else if (obj == musicButton && !MainApplication.isLobbySoundOn) {
			AudioPlayer audio = AudioPlayer.getInstance();
			audio.playSound("sounds", "menuBeat.wav");
			musicButton.getLabel().setLabel("On");
			MainApplication.isLobbySoundOn = true;
		} else if (obj == sfxButton && MainApplication.isGameSoundOn) {
			sfxButton.getLabel().setLabel("Off");
			MainApplication.isGameSoundOn = false;
		} else if (obj == sfxButton && !MainApplication.isGameSoundOn) {
			MainApplication.isGameSoundOn = true;
			sfxButton.getLabel().setLabel("On");
		}
		highlightRedAndGreenButtons(obj);
		if (obj != null) {
			showContents();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		highlightRedAndGreenButtons(obj);
		if (obj != null) {
			showContents();
		}
	}
	
	public void highlightRedAndGreenButtons(GObject obj) {
		if (MainApplication.isGameSoundOn)
			MainApplication.highlightsButton(sfxButton, obj, 0, 220, 0);
		if (!MainApplication.isGameSoundOn)
			MainApplication.highlightsButton(sfxButton, obj, 220, 0, 0);
		if (MainApplication.isLobbySoundOn)
			MainApplication.highlightsButton(musicButton, obj, 0, 220, 0);
		if (!MainApplication.isLobbySoundOn)
			MainApplication.highlightsButton(musicButton, obj, 220, 0, 0);
	}
	
	public void setLabel() {
		settingsLabel.setFont(new Font("Algerian", Font.BOLD, 75));		
		settingsLabel.setColor(Color.BLACK);
		musicLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		musicLabel.setColor(Color.BLACK);
		sfxLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		sfxLabel.setColor(Color.BLACK);
	}
}
