package pl.jasonxiii.pong.counters;

public class IntegerCounter extends Counter<Integer>
{
	public IntegerCounter(int value)
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