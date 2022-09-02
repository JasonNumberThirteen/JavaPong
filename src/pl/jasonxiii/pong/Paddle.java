package pl.jasonxiii.pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, KeyListener
{
	private boolean isMovingUp;
	private boolean isMovingDown;

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
		if(isMovingUp)
		{
			--position.y;
		}
		else if(isMovingDown)
		{
			++position.y;
		}
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
		int code = ke.getKeyCode();

		if(code == KeyEvent.VK_W && !isMovingUp)
		{
			isMovingUp = true;
		}
		else if(code == KeyEvent.VK_S && !isMovingDown)
		{
			isMovingDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		int code = ke.getKeyCode();

		if(code == KeyEvent.VK_W && isMovingUp)
		{
			isMovingUp = false;
		}
		else if(code == KeyEvent.VK_S && isMovingDown)
		{
			isMovingDown = false;
		}
	}
}