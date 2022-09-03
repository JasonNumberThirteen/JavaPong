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
	}

	public void increaseScoreToPlayerTwo()
	{
		board.playerTwo().increaseScore();
	}

	public boolean isOver()
	{
		return board.playerOne().getScore() == 1 || board.playerTwo().getScore() == 1;
	}
}