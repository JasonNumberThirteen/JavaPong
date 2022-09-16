package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;

public class BallTrigger
{
	private final Ball ball;

	public BallTrigger(Ball ball)
	{
		this.ball = ball;
	}

	public void checkTriggers()
	{
		checkHorizontalEdges();
	}

	private void checkHorizontalEdges()
	{
		GameManager gm = GameManager.INSTANCE;

		if(reachedRightEdge())
		{
			gm.increaseLeftSideScore();
			ball.onMoveOutsideField();
		}
		else if(reachedLeftEdge())
		{
			gm.increaseRightSideScore();
			ball.onMoveOutsideField();
		}
	}

	private boolean reachedLeftEdge()
	{
		return ball.getPositionX() <= -Constants.BALL_RADIUS;
	}

	private boolean reachedRightEdge()
	{
		return ball.getPositionX() >= Constants.GAME_WIDTH;
	}
}