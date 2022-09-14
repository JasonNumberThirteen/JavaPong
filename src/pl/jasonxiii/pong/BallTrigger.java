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
			gm.increasePlayerScore(gm.getBoard().playerOne());
			onMoveOutsideField();
		}
		else if(reachedLeftEdge())
		{
			gm.increasePlayerScore(gm.getBoard().playerTwo());
			onMoveOutsideField();
		}
	}

	private void onMoveOutsideField()
	{
		ball.reset();
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