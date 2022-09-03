package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.Counter;
import pl.jasonxiii.pong.PlayerInput;
import pl.jasonxiii.pong.uitexts.ScoreText;
import pl.jasonxiii.pong.gameobjects.Paddle;

import java.awt.*;

public class Player
{
	private final Paddle paddle;
	private final Counter score = new Counter(0);
	private final ScoreText scoreText;

	public Player(int x, PlayerInput input, int textXPosition)
	{
		paddle = new Paddle(x, input);
		scoreText = new ScoreText(0, new Point(textXPosition, Constants.UI_FONT_SIZE));
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

	public ScoreText getScoreText()
	{
		return scoreText;
	}
}