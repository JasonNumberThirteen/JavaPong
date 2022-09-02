package pl.jasonxiii.pong;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable
{
	private int directionX;
	private int directionY;

	public Ball(int x, int y)
	{
		super(x, y);
		randomiseDirection();
	}

	@Override
	public void update()
	{
		int movementSpeed = Constants.BALL_INITIAL_MOVEMENT_SPEED;

		position.x += movementSpeed*directionX;
		position.y += movementSpeed*directionY;

		if(position.y <= 0 || position.y >= Constants.GAME_HEIGHT - Constants.BALL_RADIUS)
		{
			directionY = -directionY;
		}
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.BALL_COLOR);
		g.fillArc(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360);
	}

	private void randomiseDirection()
	{
		directionX = Math.random() < 0.5 ? -1 : 1;
		directionY = Math.random() < 0.5 ? -1 : 1;
	}
}