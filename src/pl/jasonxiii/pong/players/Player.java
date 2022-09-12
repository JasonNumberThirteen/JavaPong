package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;
import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.gameobjects.Paddle;

public class Player
{
	private final Paddle paddle;
	private final IntegerCounter score = new IntegerCounter(Constants.PLAYER_INITIAL_SCORE);

	public Player(int x, PlayerKeyboardInput input)
	{
		paddle = new Paddle(x, input);
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

	public boolean wonTheGame()
	{
		return getScore() == Constants.PLAYER_SCORE_TO_WIN;
	}
}