package pl.jasonxiii.pong.counters;

public abstract class Counter<T extends Number>
{
	protected T value;

	public Counter(T value)
	{
		this.value = value;
	}

	public final void setTo(T value)
	{
		this.value = value;
	}

	public final T getValue()
	{
		return value;
	}

	public abstract void increaseBy(T n);
	public abstract void decreaseBy(T n);
}