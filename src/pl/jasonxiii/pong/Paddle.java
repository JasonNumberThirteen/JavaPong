package pl.jasonxiii.pong;

import java.awt.*;

public class Paddle extends GameObject
{
	public Paddle(int x, int y)
	{
		super(x, y);
	}

	public Paddle(Point position)
	{
		super(position);
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.PADDLE_COLOR);
		g.fillRect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
	}
}