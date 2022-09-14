package pl.jasonxiii.pong;

import java.awt.*;

public class MovementDirection
{
	private final Point direction;

	public MovementDirection()
	{
		direction = new Point(0, 0);
	}

	public void deflectInXAxis()
	{
		direction.x = -direction.x;
	}

	public void deflectInYAxis()
	{
		direction.y = -direction.y;
	}

	public void randomise()
	{
		direction.x = randomDirection();
		direction.y = randomDirection();
	}

	public int getDirectionX()
	{
		return direction.x;
	}

	public int getDirectionY()
	{
		return direction.y;
	}

	private int randomDirection()
	{
		return Math.random() < 0.5 ? -1 : 1;
	}
}