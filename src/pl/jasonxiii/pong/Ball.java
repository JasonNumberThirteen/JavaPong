package pl.jasonxiii.pong;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable
{
	private int directionX = -1;
	private int directionY = 1;

	public Ball(int x, int y)
	{
		super(x, y);
	}

	@Override
	public void update()
	{
		int movementSpeed = Constants.BALL_INITIAL_MOVEMENT_SPEED;

		position.x += movementSpeed*directionX;
		position.y += movementSpeed*directionY;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.BALL_COLOR);
		g.fillArc(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360);
	}
}