package pl.jasonxiii.pong;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable
{
	public Ball(int x, int y)
	{
		super(x, y);
	}

	public Ball(Point position)
	{
		super(position);
	}

	@Override
	public void update()
	{

	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.BALL_COLOR);
		g.fillArc(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360);
	}
}