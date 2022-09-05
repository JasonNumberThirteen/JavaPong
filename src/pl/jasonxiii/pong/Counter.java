package pl.jasonxiii.pong;

public abstract class Counter<T extends Number>
{
	protected T value;

	public Counter(T value)
	{
		this.value = value;
	}

	public void setTo(T value)
	{
		this.value = value;
	}

	public T getValue()
	{
		return value;
	}

	public abstract void increaseBy(T n);
	public abstract void decreaseBy(T n);
}