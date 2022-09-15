package pl.jasonxiii.pong;

public final class Methods
{
	public static int clampInt(int a, int n, int b)
	{
		return Math.min(Math.max(n, a), b);
	}

	public static int distance1D(int ya, int yb)
	{
		return Math.abs(ya - yb);
	}
}