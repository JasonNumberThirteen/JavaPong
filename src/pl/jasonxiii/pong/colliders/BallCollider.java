package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameBoard;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;

import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class BallCollider
{
	private final Ball ball;
	private final CircleCollider collider;

	public BallCollider(Ball ball)
	{
		this.ball = ball;
		collider = new CircleCollider(ball, new Arc2D.Float(new Rectangle2D.Float(), 0, 360, Arc2D.CHORD), Constants.BALL_RADIUS);
	}

	public void checkCollisionWithVerticalEdges()
	{
		if(isCollidingWithVerticalEdge())
		{
			ball.deflectInYAxis();
		}
	}

	public void checkHorizontalEdges()
	{
		GameManager gm = GameManager.INSTANCE;

		if(reachedRightEdge())
		{
			gm.increasePlayerScore(gm.getBoard().playerOne());
			ball.onMoveOutsideField();
		}
		else if(reachedLeftEdge())
		{
			gm.increasePlayerScore(gm.getBoard().playerTwo());
			ball.onMoveOutsideField();
		}
	}

	public void checkCollisionBetweenPaddles()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(isCollidingWithPaddle(gb.playerOne().getPaddle()) || isCollidingWithPaddle(gb.playerTwo().getPaddle()))
		{
			ball.onCollisionWithPaddle();
		}
	}

	private boolean isCollidingWithPaddle(Paddle paddle)
	{
		return collider.isCollidingWith(paddle.getCollider()) && ball.isGoingToPaddle(paddle);
	}

	private boolean isCollidingWithVerticalEdge()
	{
		int y = ball.getPosition().y;

		return y <= 0 || y >= Constants.GAME_HEIGHT - Constants.BALL_RADIUS;
	}

	private boolean reachedLeftEdge()
	{
		return ball.getPosition().x <= -Constants.BALL_RADIUS;
	}

	private boolean reachedRightEdge()
	{
		return ball.getPosition().x >= Constants.GAME_WIDTH;
	}
}