package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.util.HashSet;

public class GameBoard implements Updatable
{
	private final HashSet<Paddle> paddles;
	private final Ball ball;

	public GameBoard(HashSet<Paddle> paddles, Ball ball)
	{
		this.paddles = paddles;
		this.ball = ball;
	}

	@Override
	public void update(double delta)
	{
		if(GameManager.INSTANCE.isOver())
		{
			return;
		}

		paddles.forEach(p -> p.update(delta));
		ball.update(delta);
	}

	public void addPaddle(Paddle paddle)
	{
		paddles.add(paddle);
	}

	public void removePaddle(Paddle paddle)
	{
		paddles.remove(paddle);
	}

	public HashSet<Paddle> getPaddles()
	{
		return paddles;
	}
}