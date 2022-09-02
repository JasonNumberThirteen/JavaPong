package pl.jasonxiii.pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, KeyListener
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
	public void update()
	{

	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.PADDLE_COLOR);
		g.fillRect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		System.out.println("Pressed " + ke.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		System.out.println("Released " + ke.getKeyCode());
	}
}