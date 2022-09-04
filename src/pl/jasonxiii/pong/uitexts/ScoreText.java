package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;

import java.awt.*;

public class ScoreText extends UIText
{
	public ScoreText(int score, Point position)
	{
		super(String.valueOf(score), position, Constants.SCORE_TEXT_COLOR);
	}

	public void updateText(int score)
	{
		setText(String.valueOf(score));
	}
}