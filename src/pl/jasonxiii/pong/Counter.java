package pl.jasonxiii.pong;

public class Counter
{
	private int value;

	public Counter(int value)
	{
		this.value = value;
	}

	public void increaseBy(int n)
	{
		value += n;
	}

	public void decreaseBy(int n)
	{
		value -= n;
	}

	public int getValue()
	{
		return value;
	}
}