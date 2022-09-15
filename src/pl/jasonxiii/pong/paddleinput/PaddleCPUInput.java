package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.GameBoard;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class PaddleCPUInput extends PaddleInput
{
	private Paddle paddle;

	@Override
	public boolean isMovingUp()
	{
		return ballIsHigherThanPaddle();
	}

	@Override
	public boolean isMovingDown()
	{
		return ballIsLowerThanPaddle();
	}

	public void setPaddle(Paddle paddle)
	{
		this.paddle = paddle;
	}

	private boolean ballIsHigherThanPaddle()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(cannotCheckMovementDirection(gb))
		{
			return false;
		}

		return ballPositionY(gb) < paddle.centerY();
	}

	private boolean ballIsLowerThanPaddle()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(cannotCheckMovementDirection(gb))
		{
			return false;
		}

		return ballPositionY(gb) > paddle.centerY();
	}

	private boolean cannotCheckMovementDirection(GameBoard gb)
	{
		return paddle == null || gb == null;
	}

	private int ballPositionY(GameBoard gb)
	{
		if(gb == null)
		{
			return -1;
		}

		return gb.ball().getPosition().y;
	}
}