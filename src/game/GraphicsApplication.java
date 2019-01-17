package game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.program.GraphicsProgram;

public abstract class GraphicsApplication extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GraphicsPane curScreen;

	public GraphicsApplication() {
		super();
		setupInteractions();
	}

	private void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}

	protected void switchToScreen(GraphicsPane newScreen) {
		if (curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		curScreen = newScreen;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (curScreen != null) {
			curScreen.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (curScreen != null) {
			curScreen.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (curScreen != null) {
			curScreen.keyReleased(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
}
