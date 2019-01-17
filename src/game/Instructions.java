package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class Instructions extends GraphicsPane {
	private MainApplication program;
	
	public static GImage background = new GImage("settings.png", 0, 0);
	private GImage spaceBar = new GImage("spacebar.png", (MainApplication.WINDOW_WIDTH/2) - 280, 180);
	private GImage escape = new GImage("escape.png", (MainApplication.WINDOW_WIDTH/2) + 200, 170);
	private GLabel title = new GLabel("Instructions", 220, 100);
	private GLabel esc = new GLabel("Press Esc to MENU/PAUSE", (MainApplication.WINDOW_WIDTH/2) + 100, 300);
	private GLabel instructions = new GLabel("Press Space to Fly/Jump", (MainApplication.WINDOW_WIDTH/2) - 400, 300);
	private GLabel instructions1 = new GLabel("Objective: Your goal is to avoid hitting the pipes.", (MainApplication.WINDOW_WIDTH/2) - 380, 400);
	private GLabel instructions2 = new GLabel("Survive as long as you can! Earn points!", (MainApplication.WINDOW_WIDTH/2) - 240, 435);

	
	public Instructions(MainApplication app) {
		program = app;
		setEsc();
		setTitle();
		setInstructions();
	}
	

	@Override
	public void showContents() {
		program.add(background);
		program.add(spaceBar);
		program.add(escape);
		program.add(title);
		program.add(esc);
		program.add(instructions);
		program.add(instructions1);
		program.add(instructions2);
		
	}

	@Override
	public void hideContents() {
		program.remove(escape);
		program.remove(spaceBar);
		program.remove(title);
		program.remove(esc);
		program.remove(instructions);
		program.remove(instructions1);
		program.remove(instructions2);
		program.remove(background);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == (KeyEvent.VK_ESCAPE)) {
			program.switchToMenu();
			hideContents();
		}
	}
	
	public void setEsc() {
		esc.setColor(Color.BLACK);
		esc.setFont(new Font("Verdana", Font.PLAIN, 24));
	}
	
	public void setInstructions() {
		instructions.setColor(Color.BLACK);
		instructions1.setColor(Color.BLACK);
		instructions1.setFont(new Font("Verdana", Font.PLAIN, 24));
		instructions2.setColor(Color.BLACK);
		instructions2.setFont(new Font("Verdana", Font.PLAIN, 24));
		instructions.setFont(new Font("Verdana", Font.PLAIN, 24));
	}
	
	public void setTitle() {
		title.setFont(new Font("Algerian", Font.BOLD, 75));
		title.setColor(Color.BLACK);
	}
}
