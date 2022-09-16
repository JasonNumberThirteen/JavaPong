package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.counters.IntegerCounter;

import java.awt.*;

public class ScoreText extends UIText
{
	private IntegerCounter counter;

	public ScoreText(Point position)
	{
		super(position, Constants.SIDE_SCORE_TEXT_COLOR, String.valueOf(Constants.SIDE_INITIAL_SCORE));
	}

	public final void setCounter(IntegerCounter ic)
	{
		counter = ic;
	}

	public void updateText()
	{
		setText(String.valueOf(counter.getValue()));
	}
}