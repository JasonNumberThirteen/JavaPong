package pl.jasonxiii.pong.gameobjects;

import java.awt.*;

public abstract class GameObject
{
	private final Point position;

	public GameObject(int x, int y)
	{
		this.position = new Point(x, y);
	}

	public void setPosition(int x, int y)
	{
		position.setLocation(x, y);
	}

	public void setPositionX(int x)
	{
		position.x = x;
	}

	public void setPositionY(int y)
	{
		position.y = y;
	}

	public void addToPosition(int x, int y)
	{
		addToPositionX(x);
		addToPositionY(y);
	}

	public void addToPositionX(int x)
	{
		position.x += x;
	}

	public void addToPositionY(int y)
	{
		position.y += y;
	}

	public Point getPosition()
	{
		return position;
	}

	public int getPositionX()
	{
		return position.x;
	}

	public int getPositionY()
	{
		return position.y;
	}
}