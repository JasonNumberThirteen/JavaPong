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
	private final PaddleInput input;
	private final MovementDirection movementDirection = new MovementDirection();
	private final BoxCollider collider = new BoxCollider(this, new Point(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT));

	public Paddle(int x, PaddleInput input)
	{
		super(x, Constants.PADDLE_INITIAL_Y);

		this.input = input;
	}

	@Override
	public void update(double delta)
	{
		input.update();
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

	private void setMovementDirection()
	{
		int y = 0;

		if(input.isMovingUp())
		{
			y = -1;
		}
		else if(input.isMovingDown())
		{
			y = 1;
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

	public BoxCollider getCollider()
	{
		return collider;
	}

	public PaddleInput getInput()
	{
		return input;
	}
}