package game;

import java.awt.Color;
import java.awt.Font;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class LeaderboardsPane extends GraphicsPane 
{
	private MainApplication program;
	
	private GImage leaderboardsImage = new GImage("settings.png", 0, 0);
	private GLabel leaderboardLabel = new GLabel("Leaderboards: ", 160, 100);
	
	private File leaderboardsLocation = new File("Leaderboards.txt");
	private boolean iFileExist = leaderboardsLocation.exists();
	
	private ArrayList<GLabel> highScoreLabels = new ArrayList<GLabel>();
	private List<Integer> gameScores = new ArrayList<Integer>();
	
	public LeaderboardsPane(MainApplication app) throws IOException 
	{
		this.program = app;
		setLabel();
	}

	@Override
	public void showContents() 
	{
		try 
		{
			getScore();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		program.add(leaderboardsImage);
		program.add(leaderboardLabel);
		for (GLabel labels : highScoreLabels) 
		{
			program.add(labels);
		}
	}

	@Override
	public void hideContents() 
	{
		program.remove(leaderboardsImage);
		program.remove(leaderboardLabel);
		for (GLabel labels : highScoreLabels) 
		{
			program.remove(labels);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// On Escape press, goes back to menu screen
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
	
	public void setLabel() 
	{
		leaderboardLabel.setFont(new Font("Algerian", Font.BOLD, 75));		
		leaderboardLabel.setColor(Color.BLACK);
	}
	
	public void getScore() throws IOException
	{
		if (iFileExist) {
			gameScores.removeAll(gameScores);
			highScoreLabels.removeAll(highScoreLabels);
			try {
			readFiles();
			createLabels();
			setLabelColors();
			} catch (NumberFormatException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void readFiles() throws IOException 
	{
		Scanner sc = new Scanner(leaderboardsLocation);
		while (sc.hasNextLine()) 
		{
			String line = sc.nextLine();
			gameScores.add(Integer.parseInt(line));
		}
		sc.close();
		Collections.sort(gameScores);
		Collections.reverse(gameScores);
	}
	
	public void createLabels() 
	{
		for (int i = 0; i < gameScores.size() && i < 5; i++) 
		{
			GLabel scoreLabel = new GLabel(null, 450, 180 + 70 * i);
			scoreLabel.setLabel(gameScores.get(i).toString());
			highScoreLabels.add(scoreLabel);
		}
	}
	
	public void setLabelColors() 
	{
		for (GLabel labels : highScoreLabels) 
		{
			labels.setColor(Color.RED);
			labels.setFont(new Font("Verdana", Font.BOLD, 30));
		}
	}
}
