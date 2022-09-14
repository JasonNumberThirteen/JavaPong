package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;
import pl.jasonxiii.pong.colliders.BoxCollider;
import pl.jasonxiii.pong.interfaces.Collidable;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends GameObject implements Updatable, Drawable, Collidable, KeyListener
{
	private final PlayerKeyboardInput input;
	private final BoxCollider collider = new BoxCollider(this, new Point(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT));

	public Paddle(int x, PlayerKeyboardInput input)
	{
		super(x, Constants.PADDLE_INITIAL_Y);

		this.input = input;
	}

	@Override
	public void update(double delta)
	{
		move(delta);
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
		input.setKeyEvent(ke);
		input.controlInput(true);
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		input.setKeyEvent(ke);
		input.controlInput(false);
	}

	private void move(double delta)
	{
		int movementStep = (int)(Constants.PADDLE_MOVEMENT_SPEED*delta);
		int max = Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT;
		int direction = movementDirection();
		int offset = movementStep*direction;

		position.y = Methods.clampInt(0, position.y + offset, max);
	}

	private int movementDirection()
	{
		if(input.isMovingUp())
		{
			return -1;
		}
		else if(input.isMovingDown())
		{
			return 1;
		}

		return 0;
	}

	public BoxCollider getCollider()
	{
		return collider;
	}
}