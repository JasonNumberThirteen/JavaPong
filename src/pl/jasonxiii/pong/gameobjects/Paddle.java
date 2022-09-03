package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, KeyListener
{
	private final int upMovementCode;
	private final int downMovementCode;

	private boolean isMovingUp;
	private boolean isMovingDown;

	public Paddle(int x, int upMovementCode, int downMovementCode)
	{
		super(x, Constants.PADDLE_INITIAL_Y);

		this.upMovementCode = upMovementCode;
		this.downMovementCode = downMovementCode;
	}

	@Override
	public void update()
	{
		if(isMovingUp)
		{
			position.y = Methods.clampInt(0, position.y - Constants.PADDLE_MOVEMENT_SPEED, Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT);
		}
		else if(isMovingDown)
		{
			position.y = Methods.clampInt(0, position.y + Constants.PADDLE_MOVEMENT_SPEED, Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT);
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

		if(code == upMovementCode && !isMovingUp)
		{
			isMovingUp = true;
		}
		else if(code == downMovementCode && !isMovingDown)
		{
			isMovingDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		int code = ke.getKeyCode();

		if(code == upMovementCode && isMovingUp)
		{
			isMovingUp = false;
		}
		else if(code == downMovementCode && isMovingDown)
		{
			isMovingDown = false;
		}
	}
}