package pl.jasonxiii.pong.uitexts;

import java.awt.*;

public class ScoreText extends UIText
{
	public ScoreText(int score, Point position)
	{
		super(String.valueOf(score), position, Color.WHITE);
	}

	public void updateText(int score)
	{
		setText(String.valueOf(score));
	}
}