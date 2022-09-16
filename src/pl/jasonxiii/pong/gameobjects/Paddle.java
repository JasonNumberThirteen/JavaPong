package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.colliders.BoxCollider;
import pl.jasonxiii.pong.interfaces.*;
import pl.jasonxiii.pong.paddleinput.PaddleInput;

import java.awt.*;

public class Paddle extends MovingGameObject implements Updatable, Drawable, Collidable
{
	private final BoxCollider collider = new BoxCollider(this, new Point(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT));

	private PaddleInput input;

	public Paddle(int x, PaddleInput pi)
	{
		this(x);
		setInput(pi);
	}

	public Paddle(int x)
	{
		super(x, Constants.PADDLE_INITIAL_Y);
		getMovementSpeed().setTo(Constants.PADDLE_MOVEMENT_SPEED);
	}

	@Override
	public void update(double delta)
	{
		setMovementDirection();
		move(delta);
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Constants.PADDLE_COLOR);
		g.fillRect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
	}

	@Override
	public void move(double delta)
	{
		int movementStep = movementStep(delta);
		int max = Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT;
		int directionY = getMovementDirection().getDirectionY();
		int offset = movementStep*directionY;

		position.y = Methods.clampInt(0, position.y + offset, max);
	}

	@Override
	public int hashCode()
	{
		return position.x;
	}

	@Override
	public boolean equals(Object o)
	{
		if(getClass() != o.getClass())
		{
			return false;
		}

		Paddle p = (Paddle)o;

		return position.x == p.position.x;
	}

	public void setInput(PaddleInput pi)
	{
		input = pi;
	}

	public BoxCollider getCollider()
	{
		return collider;
	}

	public PaddleInput getInput()
	{
		return input;
	}

	public int centerY()
	{
		return position.y + (collider.getCollider().height >> 1);
	}

	private void setMovementDirection()
	{
		int y = 0;

		if(input != null)
		{
			if(input.isMovingUp())
			{
				y = -1;
			}
			else if(input.isMovingDown())
			{
				y = 1;
			}
		}

		getMovementDirection().setDirectionY(y);
	}
}