package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.counters.IntegerCounter;

import java.awt.*;

public class ScoreText extends UIText
{
	private IntegerCounter counter;

	public ScoreText(Point position)
	{
		super(String.valueOf(Constants.SIDE_INITIAL_SCORE), position, Constants.SIDE_SCORE_TEXT_COLOR);
	}

	public void setCounter(IntegerCounter ic)
	{
		counter = ic;
	}

	public void updateText()
	{
		setText(String.valueOf(counter.getValue()));
	}
}