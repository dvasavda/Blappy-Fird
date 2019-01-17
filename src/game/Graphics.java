package game;

import java.awt.Rectangle;

import acm.graphics.GImage;

public class Graphics {
	public Rectangle hitBox;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private String fileLocation;
	
	private GImage img;
	private MainApplication program;

	public Graphics(String fileLocation, int x, int y, int height, int width) {
		this.fileLocation = fileLocation;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		img = new GImage(fileLocation, x, y);
		hitBox = new Rectangle();
	}
	public void draw(MainApplication app) {
		this.program = app;
		img = new GImage(fileLocation, x, y);
		showContents();
	}

	// Setters:
	public void changeLocation(double xLoc, double yLoc) {
		img.setLocation(xLoc, yLoc);
	}

	// TEST
	public void changeFloatLocation(float xLoc, float yLoc) {
		img.setLocation(xLoc, yLoc);
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	// Getters:
	public String getfileLocation() {
		return fileLocation;
	}

	public double getX() {
		return img.getX();
	}

	public double getY() {
		return img.getY();
	}
	
	public double getHeight() {
		return img.getHeight();
	}
	
	public double getWidth() {
		return img.getWidth();
	}
	

	public void showContents() {
		program.add(img);
	}
	
	public void hideContents() {
		program.remove(img);
	}
	
	public Rectangle getBounds() {
		hitBox = new Rectangle(x, y, width, height);
		return hitBox;
	}
}
