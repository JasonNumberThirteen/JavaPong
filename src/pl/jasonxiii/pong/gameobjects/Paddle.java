package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.PlayerInput;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, KeyListener
{
	private final PlayerInput input;

	private boolean isMovingUp;
	private boolean isMovingDown;

	public Paddle(int x, PlayerInput input)
	{
		super(x, Constants.PADDLE_INITIAL_Y);

		this.input = input;
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
		controlInput(ke, true);
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		controlInput(ke, false);
	}

	private void controlInput(KeyEvent ke, boolean enable)
	{
		int code = ke.getKeyCode();

		if(code == input.upMovementCode() && isMovingUp != enable)
		{
			isMovingUp = enable;
		}
		else if(code == input.downMovementCode() && isMovingDown != enable)
		{
			isMovingDown = enable;
		}
	}
}