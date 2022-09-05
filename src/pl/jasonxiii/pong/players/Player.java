package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.PlayerInput;
import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.uitexts.ScoreText;
import pl.jasonxiii.pong.gameobjects.Paddle;

import java.awt.*;

public class Player
{
	private final Paddle paddle;
	private final IntegerCounter score = new IntegerCounter(0);
	private final ScoreText scoreText;
	private final int number;

	public Player(int x, PlayerInput input, int textXPosition, int number)
	{
		paddle = new Paddle(x, input);
		scoreText = new ScoreText(score.getValue(), new Point(textXPosition, Constants.SCORE_TEXT_Y));
		this.number = number;
	}

	public int getNumber()
	{
		return number;
	}

	public void increaseScore()
	{
		score.increaseBy(1);
		scoreText.updateText(score.getValue());
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