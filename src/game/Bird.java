package game;

import java.awt.Rectangle;

import acm.program.GraphicsProgram;

/*
 * The Bird class will be in charge of the bird's behavior and graphics
 * TODO
 * Make another enum class to choose different skins. *DO LATER*
 */
public class Bird extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Physics p = new Physics();
	private MainApplication program;
	private Graphics g;
	
	public static Rectangle bounds;
	
	public Bird(MainApplication app) {
		program = app;
		g = createBird();
		
		//HITBOX FOR BIRD CHANGE LAST TWO VALUES
		bounds = new Rectangle((int)p.x, (int)p.y, 60, 57);
		
	}

	public void drawBird() {
		g.draw(program);
	}
	
	public Graphics createBird() {
		Graphics temp;
		temp = new Graphics("flappy-bird.png", 100, 250, 50, 50);
		return temp;
	}
	
	public void birdBounds() {
		System.out.println("IMG Width " + g.getWidth());
		System.out.println("IMG Height " + g.getHeight());
		System.out.println("Bird Y: " + (g.getBounds().getY() + (int) p.getY()));
		System.out.println("BIRD X:" + g.getBounds().getX());
	}

	/*
	 * birdJump() will make the bird fly/jump. All that should be needed here is an
	 * downwards motion. It pull the birdJump method created in the Physic's class. 
	 */
	public void birdJump() {
		p.birdJump();
		g.changeFloatLocation(p.getX(), p.getY());
		bounds.setLocation((int)p.getX(),(int) p.getY());
	}

	//Method will be in charge of bird physics
	public void birdPhysics() {
		p.birdPhysics();
		g.changeFloatLocation(p.getX(), p.getY());
		bounds.setLocation((int)p.getX(),(int) p.getY());
	}
	
	public float birdGetX() {
		return p.x;
	}
	
	public float birdGetY() {
		return p.y;
	}
	
	public void birdReset() {
		p.setX(100);
		p.setY(100);
		g.hideContents();
	}
	
	public Rectangle getBounds() {
		return bounds;
    }


	
	
	/*public Rectangle getBirdTop() {
	int x = (int) g.getBounds().getX();
	int y = (int) (g.getBounds().getY() + p.getY());
	int width = 30;
	int height = 150;
	Rectangle top = new Rectangle(x,y,width,height);
	//System.out.println(top);
	return top;
}
public Rectangle getBirdRightSide() {
	int x = (int) g.getBounds().getX();
	int y = (int) (g.getBounds().getY() + p.getY());
	int width = (int) g.getWidth();
	int height = (int) g.getHeight();
	Rectangle middle = new Rectangle(x,y,width,height);
	return middle;
}

public Rectangle getBirdBottom() {
	int x = (int) g.getBounds().getX();
	int y = (int) (g.getBounds().getY() + p.getY());
	int width = (int) g.getBounds().getWidth();
	int height = (int) g.getBounds().getHeight();
	Rectangle bottom = new Rectangle(x,y,width,height);
	return bottom;
}*/
	
	
}