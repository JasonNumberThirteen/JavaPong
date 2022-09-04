package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.PlayerInput;
import pl.jasonxiii.pong.interfaces.Collidable;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, Collidable, KeyListener
{
	private final PlayerInput input;

	public Paddle(int x, PlayerInput input)
	{
		super(x, Constants.PADDLE_INITIAL_Y);

		this.input = input;
	}

	@Override
	public void update(double delta)
	{
		int movementSpeed = (int)(Constants.PADDLE_MOVEMENT_SPEED*delta);

		if(input.isMovingUp())
		{
			position.y = Methods.clampInt(0, position.y - movementSpeed, Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT);
		}
		else if(input.isMovingDown())
		{
			position.y = Methods.clampInt(0, position.y + movementSpeed, Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT);
		}
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.PADDLE_COLOR);
		g.fillRect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
		g.setColor(Color.RED);
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		input.controlInput(ke, true);
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		input.controlInput(ke, false);
	}

	public Rectangle collisionBox()
	{
		return new Rectangle(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
	}
}