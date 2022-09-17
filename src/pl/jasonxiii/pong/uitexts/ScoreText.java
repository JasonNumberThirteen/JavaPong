package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.counters.IntegerCounter;

import java.awt.*;

public class ScoreText extends UIText
{
	private final IntegerCounter counter;

	public ScoreText(Point position, IntegerCounter ic)
	{
		super(position, Constants.SIDE_SCORE_TEXT_COLOR, String.valueOf(Constants.SIDE_INITIAL_SCORE));

		counter = ic;
	}

	@Override
	public void update()
	{
		setText(String.valueOf(counter.getValue()));
	}
}