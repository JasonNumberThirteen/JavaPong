package pl.jasonxiii.pong;

public final class Methods
{
	public static int clampInt(int a, int n, int b)
	{
		return (int)Math.min(Math.max(n, a), b);
	}
}