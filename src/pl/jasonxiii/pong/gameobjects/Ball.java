package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.colliders.BallCollider;
import pl.jasonxiii.pong.counters.*;
import pl.jasonxiii.pong.interfaces.*;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable, Collidable
{
	private final MovementDirection movementDirection = new MovementDirection();
	private final IntegerCounter movementSpeed = new IntegerCounter(0);
	private final FloatCounter delayTimer = new FloatCounter(0f);
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

	public void reset()
	{
		setPosition(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		movementDirection.randomise();
		delayTimer.setTo(Constants.BALL_INITIAL_DELAY_TIMER);
		movementSpeed.setTo(Constants.BALL_INITIAL_MOVEMENT_SPEED);
	}

	public boolean isGoingToPaddle(Paddle paddle)
	{
		int requiredDirection = (int)Math.signum(paddle.position.x - position.x);
		int directionX = movementDirection.getDirectionX();

		return requiredDirection < 0 ? directionX < 0 : directionX > 0;
	}

	public void onCollisionWithPaddle()
	{
		movementDirection.deflectInXAxis();
		movementSpeed.increaseBy(Constants.BALL_SPEED_INCREASE_PER_PADDLE_DEFLECT);
	}

	public void onCollisionWithVerticalEdge()
	{
		movementDirection.deflectInYAxis();
	}

	private void move(double delta)
	{
		int movementStep = (int)(movementSpeed.getValue()*delta);

		position.x += movementStep*movementDirection.getDirectionX();
		position.y += movementStep*movementDirection.getDirectionY();
	}

	private boolean canMove()
	{
		return delayTimer.getValue() <= 0;
	}
}