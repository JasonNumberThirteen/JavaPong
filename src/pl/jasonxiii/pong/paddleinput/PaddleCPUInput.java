package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameBoard;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class PaddleCPUInput extends PaddleInput
{
	private Paddle paddle;

	@Override
	public boolean isMovingUp()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(paddle == null || gb == null)
		{
			return false;
		}

		return gb.ball().getPosition().y < paddle.getPosition().y;
	}

	@Override
	public boolean isMovingDown()
	{
		GameBoard gb = GameManager.INSTANCE.getBoard();

		if(paddle == null || gb == null)
		{
			return false;
		}

		return gb.ball().getPosition().y > (paddle.getPosition().y + Constants.PADDLE_HEIGHT);
	}

	public void setPaddle(Paddle paddle)
	{
		this.paddle = paddle;
	}
}