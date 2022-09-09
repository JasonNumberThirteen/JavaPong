package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;

import java.awt.*;

public class ScoreText extends UIText
{
	public ScoreText(Point position)
	{
		super(String.valueOf(Constants.PLAYER_INITIAL_SCORE), position, Constants.SCORE_TEXT_COLOR);
	}

	public void updateText(int score)
	{
		setText(String.valueOf(score));
	}
}