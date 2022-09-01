package pl.jasonxiii.pong;

import java.awt.*;

public class Ball extends GameObject
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
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillArc(position.x, position.y, 16, 16, 0, 360);
	}
}