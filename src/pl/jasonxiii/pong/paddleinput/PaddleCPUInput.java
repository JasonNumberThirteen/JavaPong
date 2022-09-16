package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameBoard;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class PaddleCPUInput extends PaddleInput
{
	private Paddle paddle;

	@Override
	public boolean isMovingUp()
	{
		return ballIsHigherThanPaddle() && distanceToBallIsTooLong();
	}

	@Override
	public boolean isMovingDown()
	{
		return ballIsLowerThanPaddle() && distanceToBallIsTooLong();
	}

	public final void setPaddle(Paddle paddle)
	{
		this.paddle = paddle;
	}

	private boolean ballIsHigherThanPaddle()
	{
		if(cannotCheckMovementDirection())
		{
			return false;
		}

		return ballPositionY() < paddle.centerY();
	}

	private boolean ballIsLowerThanPaddle()
	{
		if(cannotCheckMovementDirection())
		{
			return false;
		}

		return ballPositionY() > paddle.centerY();
	}

	private boolean cannotCheckMovementDirection()
	{
		return paddle == null || GameManager.INSTANCE.getBoard() == null;
	}

	private boolean distanceToBallIsTooLong()
	{
		int paddleCenterY = paddle.centerY();
		int ballPositionY = ballPositionY();

		return Methods.distance1D(paddleCenterY, ballPositionY) >= Constants.PADDLE_CPU_MINIMUM_DISTANCE_TO_MOVE;
	}

	private int ballPositionY()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(gb == null)
		{
			return -1;
		}

		return gb.ball().getPositionY();
	}
}