package pl.jasonxiii.pong;

import java.awt.*;

public abstract class GameObject
{
	protected final Point position;

	public GameObject(int x, int y)
	{
		this.position = new Point(x, y);
	}
}