package pl.jasonxiii.pong;

public enum GameManager
{
	INSTANCE;

	private GameBoard board;

	public void setBoard(GameBoard board)
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
		int scoreToWin = Constants.PLAYER_SCORE_TO_WIN;

		return board.playerOne().getScore() == scoreToWin || board.playerTwo().getScore() == scoreToWin;
	}
}