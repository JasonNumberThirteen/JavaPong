package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.gameobjects.Paddle;

public abstract class PaddleInput
{
	private Paddle paddle;

	public abstract boolean isMovingUp();
	public abstract boolean isMovingDown();

	public final void setPaddle(Paddle paddle)
	{
		this.paddle = paddle;
	}

	public final Paddle getPaddle()
	{
		return paddle;
	}
}