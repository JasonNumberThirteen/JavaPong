package pl.jasonxiii.pong;

import java.awt.*;

public final class MovementDirection {
	private final Point direction = new Point(0, 0);

	public void randomise() {
		setDirectionX(randomDirection());
		setDirectionY(randomDirection());
	}

	public void deflectInXAxis() {
		setDirectionX(-getDirectionX());
	}

	public void deflectInYAxis() {
		setDirectionY(-getDirectionY());
	}

	public void setDirectionX(int x) {
		direction.x = x;
	}

	public void setDirectionY(int y) {
		direction.y = y;
	}

	public int getDirectionX() {
		return direction.x;
	}

	public int getDirectionY() {
		return direction.y;
	}

	private int randomDirection() {
		return Math.random() < 0.5 ? -1 : 1;
	}
}