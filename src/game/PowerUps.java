package game;

public enum PowerUps {
	SLOWTIME, INVICIBILITY, LIFEUP, EXTRAPOINT;

	public String toString() {
		switch (this) {
		case SLOWTIME:
			return "slowtime";
		case INVICIBILITY:
			return "invicibility";
		case LIFEUP:
			return "lifeup";
		case EXTRAPOINT:
			return "extrapoint";
		}
		return "n/a";
	}
}
