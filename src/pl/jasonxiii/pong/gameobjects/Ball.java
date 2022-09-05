package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.colliders.BoxCollider;
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
	private final BoxCollider collider = new BoxCollider(this, new Rectangle(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS));

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
			checkCollisionWithVerticalEdges();
			checkHorizontalEdges();
			checkCollisionBetweenPaddles();
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

	private void move(double delta)
	{
		int movementStep = (int)(movementSpeed.getValue()*delta);

		position.x += movementStep*directionX;
		position.y += movementStep*directionY;
	}

	private void checkCollisionWithVerticalEdges()
	{
		if(isCollidingWithVerticalEdge())
		{
			deflectInYAxis();
		}
	}

	private void checkHorizontalEdges()
	{
		GameManager gm = GameManager.INSTANCE;

		if(reachedRightEdge())
		{
			gm.increaseScoreToPlayerOne();
			onMoveOutsideField();
		}
		else if(reachedLeftEdge())
		{
			gm.increaseScoreToPlayerTwo();
			onMoveOutsideField();
		}
	}

	private void checkCollisionBetweenPaddles()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(isCollidingWith(gb.playerOne().getPaddle()) || isCollidingWith(gb.playerTwo().getPaddle()))
		{
			onCollisionWithPaddle();
		}
	}

	private void onCollisionWithPaddle()
	{
		deflectInXAxis();
		movementSpeed.increaseBy(Constants.BALL_SPEED_INCREASE_PER_PADDLE_DEFLECT);
	}

	private void onMoveOutsideField()
	{
		setPosition(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		randomiseDirection();
		delayTimer.setTo(Constants.BALL_INITIAL_DELAY_TIMER);
		movementSpeed.setTo(Constants.BALL_INITIAL_MOVEMENT_SPEED);
	}

	private boolean canMove()
	{
		return delayTimer.getValue() <= 0;
	}

	private boolean isCollidingWithVerticalEdge()
	{
		return position.y <= 0 || position.y >= Constants.GAME_HEIGHT - Constants.BALL_RADIUS;
	}

	private boolean reachedLeftEdge()
	{
		return position.x <= -Constants.BALL_RADIUS;
	}

	private boolean reachedRightEdge()
	{
		return position.x >= Constants.GAME_WIDTH;
	}

	private boolean isCollidingWith(Collidable c)
	{
		if(c.getClass() == Paddle.class)
		{
			Paddle paddle = (Paddle)c;

			return paddle.collisionBox().intersects(collider.collisionBox());
		}

		return false;
	}

	private void deflectInXAxis()
	{
		directionX = -directionX;
	}

	private void deflectInYAxis()
	{
		directionY = -directionY;
	}

	private void randomiseDirection()
	{
		directionX = Math.random() < 0.5 ? -1 : 1;
		directionY = Math.random() < 0.5 ? -1 : 1;
	}
}