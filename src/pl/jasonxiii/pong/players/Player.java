package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;
import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class Player
{
	private final Paddle paddle;
	private final IntegerCounter score = new IntegerCounter(Constants.PLAYER_INITIAL_SCORE);
	private final int number;

	public Player(int x, PlayerKeyboardInput input, int number)
	{
		paddle = new Paddle(x, input);
		this.number = number;
	}

	public int getNumber()
	{
		return number;
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