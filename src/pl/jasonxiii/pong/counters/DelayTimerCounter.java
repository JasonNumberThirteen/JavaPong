package pl.jasonxiii.pong.counters;

public class DelayTimerCounter extends Counter<Float>
{
	public DelayTimerCounter(Float value)
	{
		super(value);
	}

	@Override
	public void increaseBy(Float n)
	{
		value += n;
	}

	@Override
	public void decreaseBy(Float n)
	{
		value -= n;
	}
}