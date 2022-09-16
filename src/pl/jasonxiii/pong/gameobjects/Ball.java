package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.counters.*;
import pl.jasonxiii.pong.interfaces.*;
import pl.jasonxiii.pong.colliders.BallCollider;

import java.awt.*;

public class Ball extends MovingGameObject implements Updatable, Drawable, Collidable
{
	private final FloatCounter delayTimer = new FloatCounter();
	private final BallCollider collider = new BallCollider(this);
	private final BallTrigger trigger = new BallTrigger(this);

	public Ball()
	{
		super(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		reset();
	}

	@Override
	public void update(double delta)
	{
		if(canMove())
		{
			move(delta);
			collider.checkCollisions();
			trigger.checkTriggers();
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

	@Override
	public void move(double delta)
	{
		int movementStep = movementStep(delta);
		MovementDirection md = getMovementDirection();

		position.x += movementStep*md.getDirectionX();
		position.y += movementStep*md.getDirectionY();
	}

	public void onCollisionWithPaddle()
	{
		getMovementDirection().deflectInXAxis();
		getMovementSpeed().increaseBy(Constants.BALL_SPEED_INCREASE_PER_PADDLE_DEFLECT);
	}

	public void onCollisionWithVerticalEdge()
	{
		getMovementDirection().deflectInYAxis();
	}

	public void onMoveOutsideField()
	{
		reset();
	}

	public boolean isGoingToPaddle(Paddle paddle)
	{
		int requiredDirection = (int)Math.signum(paddle.position.x - position.x);
		int directionX = getMovementDirection().getDirectionX();

		return requiredDirection < 0 ? directionX < 0 : directionX > 0;
	}

	private void reset()
	{
		setPosition(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		getMovementDirection().randomise();
		delayTimer.setTo(Constants.BALL_INITIAL_DELAY_TIMER);
		getMovementSpeed().setTo(Constants.BALL_INITIAL_MOVEMENT_SPEED);
	}

	private boolean canMove()
	{
		return delayTimer.isLessThanOrEqualTo(0f);
	}
}