package pl.jasonxiii.pong;

public class GameManager
{
	private final GameBoard board;

	public GameManager(GameBoard board)
	{
		this.board = board;
	}

	public void increaseScoreToPlayerOne()
	{
		board.playerOne().increaseScore();
		System.out.println("P1: " + board.playerOne().getScore());
	}

	public void increaseScoreToPlayerTwo()
	{
		board.playerTwo().increaseScore();
		System.out.println("P2: " + board.playerTwo().getScore());
	}

	public boolean isOver()
	{
		return board.playerOne().getScore() == 1 || board.playerTwo().getScore() == 1;
	}
}