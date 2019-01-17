package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GLabel;

public class MenuPane extends GraphicsPane {
	private MainApplication program;

	private static GRect menuBox = new GRect(0, 157, 1000, 60);

	private String[] glabelStrings = { "Start Game", "Instructions", "Leaderboards", "Settings", "Quit" };
	private ArrayList<GLabel> gLabel = new ArrayList<GLabel>();

	public MenuPane(MainApplication app) 
	{
		program = app;
		menuBox.setFillColor(Color.WHITE);
		menuBox.setFilled(true);
		
		for (int i = 0; i < 5; i++) 
		{
			GLabel label = new GLabel(glabelStrings[i], (MainApplication.WINDOW_WIDTH / 2) - 180, 200 + 70 * i);
			label.setColor(Color.WHITE);
			label.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
			gLabel.add(label);
		}
	}

	@Override
	public void showContents() 
	{
		program.add(MainApplication.background);
		program.add(menuBox);
		for (GLabel label : gLabel) 
		{
			program.add(label);
		}
	}

	@Override
	public void hideContents() 
	{
		program.remove(MainApplication.background);
		program.remove(menuBox);
		for (GLabel label : gLabel) 
		{
			program.remove(label);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == gLabel.get(0)) {
			program.switchToGame();
		}
		if (obj == gLabel.get(1)) {
			program.switchToInstructions();
		}
		if (obj == gLabel.get(2)) {
			program.switchToLeaderboards();
		}
		if (obj == gLabel.get(3)) {
			program.switchToSettings();
		}
		if (obj == gLabel.get(4)) {
			System.exit(0);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj != null) 
		{
			for (GLabel label : gLabel) 
			{
				highlightsLabel(label, obj, 0, 0, 0);
			}
		}
	}

	public static void highlightsLabel(GLabel label, GObject obj, int r, int g, int b) {
		Color highlightColor = new Color(r, g, b);
		if (obj == label || label.getY() == menuBox.getY() + 43) 
		{
			menuBox.setLocation(0, label.getY()-43);
			label.setColor(highlightColor);
		} 
		else 
		{
			label.setColor(Color.WHITE);
		}
	}
}
