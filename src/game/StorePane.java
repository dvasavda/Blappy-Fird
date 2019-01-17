package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class StorePane extends GraphicsPane {
	private MainApplication program;
	private GImage storeImage = new GImage("store.png", 0, 0);
	private GLabel storeLabel = new GLabel("Store", 350, 100);

	public StorePane(MainApplication app) {
		this.program = app;
		storeLabel.setFont(new Font("Algerian", Font.BOLD, 75));
		storeLabel.setColor(Color.BLACK);
	}

	@Override
	public void showContents() {
		program.add(storeImage);
		program.add(storeLabel);
	}

	@Override
	public void hideContents() {
		program.remove(storeImage);
		program.remove(storeLabel);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// On Escape press, goes back to menu screen
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
}
