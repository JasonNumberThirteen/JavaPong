package pl.jasonxiii.pong;

public class Player
{
	private final Paddle paddle;

	private int score = 0;

	public Player(int x, int upMovementCode, int downMovementCode)
	{
		paddle = new Paddle(x, upMovementCode, downMovementCode);
	}

	public void increaseScore()
	{
		++score;
	}

	public Paddle getPaddle()
	{
		return paddle;
	}

	public int getScore()
	{
		return score;
	}
}