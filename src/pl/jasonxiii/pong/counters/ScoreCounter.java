package pl.jasonxiii.pong.counters;

public class ScoreCounter extends Counter<Integer>
{
	public ScoreCounter(int value)
	{
		super(value);
	}

	@Override
	public void increaseBy(Integer n)
	{
		value += n;
	}

	@Override
	public void decreaseBy(Integer n)
	{
		value -= n;
	}
}