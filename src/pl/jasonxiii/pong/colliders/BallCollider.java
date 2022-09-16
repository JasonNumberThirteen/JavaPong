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

	public void checkCollisions()
	{
		checkCollisionWithVerticalEdges();
		checkCollisionBetweenPaddles();
	}

	private void checkCollisionWithVerticalEdges()
	{
		if(isCollidingWithVerticalEdge())
		{
			ball.onCollisionWithVerticalEdge();
		}
	}

	private boolean isCollidingWithVerticalEdge()
	{
		int y = ball.getPositionY();

		return y <= 0 || y >= Constants.GAME_HEIGHT - Constants.BALL_RADIUS;
	}

	private void checkCollisionBetweenPaddles()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		for (Paddle p : gb.paddles())
		{
			if(isCollidingWithPaddle(p))
			{
				ball.onCollisionWithPaddle();
			}
		}
	}

	private boolean isCollidingWithPaddle(Paddle paddle)
	{
		return collider.isCollidingWith(paddle.getCollider()) && ball.isGoingToPaddle(paddle);
	}
}