package pl.jasonxiii.pong.gameobjects;

import java.awt.*;

public abstract class GameObject {
	private final Point position;

	public GameObject(int x, int y) {
		this.position = new Point(x, y);
	}

	public final void setPosition(int x, int y) {
		position.setLocation(x, y);
	}

	public final void setPositionX(int x) {
		position.x = x;
	}

	public final void setPositionY(int y) {
		position.y = y;
	}

	public final void addToPosition(int x, int y) {
		addToPositionX(x);
		addToPositionY(y);
	}

	public final void addToPositionX(int x) {
		position.x += x;
	}

	public final void addToPositionY(int y) {
		position.y += y;
	}

	public final Point getPosition() {
		return position;
	}

	public final int getPositionX() {
		return position.x;
	}

	public final int getPositionY() {
		return position.y;
	}
}