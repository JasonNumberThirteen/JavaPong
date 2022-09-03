package pl.jasonxiii.pong.gameobjects;

import java.awt.*;

public abstract class GameObject
{
	protected final Point position;

	public GameObject(int x, int y)
	{
		this.position = new Point(x, y);
	}
}