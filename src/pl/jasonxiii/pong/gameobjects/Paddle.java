package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.MovementDirection;
import pl.jasonxiii.pong.colliders.BoxCollider;
import pl.jasonxiii.pong.interfaces.*;
import pl.jasonxiii.pong.paddleinput.PaddleInput;

import java.awt.*;

public class Paddle extends GameObject implements Updatable, Drawable, Collidable
{
	private final MovementDirection movementDirection = new MovementDirection();
	private final BoxCollider collider = new BoxCollider(this, new Point(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT));

	private PaddleInput input;

	public Paddle(int x)
	{
		super(x, Constants.PADDLE_INITIAL_Y);
	}

	public Paddle(int x, PaddleInput pi)
	{
		super(x, Constants.PADDLE_INITIAL_Y);
		setInput(pi);
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

		movementDirection.setDirectionY(y);
	}

	private void move(double delta)
	{
		int movementStep = (int)(Constants.PADDLE_MOVEMENT_SPEED*delta);
		int max = Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT;
		int offset = movementStep*movementDirection.getDirectionY();

		position.y = Methods.clampInt(0, position.y + offset, max);
	}
}