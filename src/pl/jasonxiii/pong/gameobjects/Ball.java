package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.colliders.BallCollider;
import pl.jasonxiii.pong.counters.FloatCounter;
import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.interfaces.Collidable;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable, Collidable
{
	private int directionX, directionY;

	private final IntegerCounter movementSpeed = new IntegerCounter(0);
	private final FloatCounter delayTimer = new FloatCounter(0f);
	private final BallCollider collider = new BallCollider(this);

	public Ball()
	{
		super(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		onMoveOutsideField();
	}

	@Override
	public void update(double delta)
	{
		if(canMove())
		{
			move(delta);
			collider.checkCollisionWithVerticalEdges();
			collider.checkHorizontalEdges();
			collider.checkCollisionBetweenPaddles();
		}
		else
		{
			delayTimer.decreaseBy((float)delta);
		}
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;

		g.setColor(Constants.BALL_COLOR);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillArc(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360);
	}

	public boolean isGoingToPaddle(Paddle paddle)
	{
		int requiredDirection = (int)Math.signum(paddle.position.x - position.x);

		return requiredDirection < 0 ? directionX < 0 : directionX > 0;
	}

	public void onCollisionWithPaddle()
	{
		deflectInXAxis();
		movementSpeed.increaseBy(Constants.BALL_SPEED_INCREASE_PER_PADDLE_DEFLECT);
	}

	public void onMoveOutsideField()
	{
		setPosition(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		randomiseDirection();
		delayTimer.setTo(Constants.BALL_INITIAL_DELAY_TIMER);
		movementSpeed.setTo(Constants.BALL_INITIAL_MOVEMENT_SPEED);
	}

	public void deflectInXAxis()
	{
		directionX = -directionX;
	}

	public void deflectInYAxis()
	{
		directionY = -directionY;
	}

	private void move(double delta)
	{
		int movementStep = (int)(movementSpeed.getValue()*delta);

		position.x += movementStep*directionX;
		position.y += movementStep*directionY;
	}

	private boolean canMove()
	{
		return delayTimer.getValue() <= 0;
	}

	private void randomiseDirection()
	{
		directionX = Math.random() < 0.5 ? -1 : 1;
		directionY = Math.random() < 0.5 ? -1 : 1;
	}
}