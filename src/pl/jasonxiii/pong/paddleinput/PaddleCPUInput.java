package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameBoard;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.Methods;

public class PaddleCPUInput extends PaddleInput
{
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

	private boolean ballIsHigherThanPaddle()
	{
		if(cannotCheckMovementDirection())
		{
			return false;
		}

		return ballPositionY() < getPaddle().center().y;
	}

	private boolean ballIsLowerThanPaddle()
	{
		if(cannotCheckMovementDirection())
		{
			return false;
		}

		return ballPositionY() > getPaddle().center().y;
	}

	private boolean cannotCheckMovementDirection()
	{
		return getPaddle() == null || GameManager.INSTANCE.getBoard() == null;
	}

	private boolean distanceToBallIsTooLong()
	{
		int paddleCenterY = getPaddle().center().y;
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