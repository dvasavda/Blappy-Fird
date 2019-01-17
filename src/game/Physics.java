package game;

/**
 * Physics class manages the physics of the objects in the game. For now, bird
 * is the only object moving dynamically. If enemies or any objects needed
 * gravity, implement here in this class.
 *
 */

public class Physics {
	public float x;
	public float y;
	public float vx;
	public float vy;

	
	// Constructor for physics. Values also determine the starting position of the
	// bird as well.
	public Physics() {
		x = 100;
		y = 100;

	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	// Controls the jumping/flying action for the bird
	public void birdJump() {
		vy = -8;
	}

	// Controls the behavior of the bird
	public void birdPhysics() {
		x += vx;
		y += vy;
		
		vy += 0.5f;
	}
	

}
