package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Counter;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class Player
{
	private final Paddle paddle;

	private final Counter score = new Counter(0);

	public Player(int x, int upMovementCode, int downMovementCode)
	{
		paddle = new Paddle(x, upMovementCode, downMovementCode);
	}

	public void increaseScore()
	{
		score.increaseBy(1);
	}

	public Paddle getPaddle()
	{
		return paddle;
	}

	public int getScore()
	{
		return score.getValue();
	}
}