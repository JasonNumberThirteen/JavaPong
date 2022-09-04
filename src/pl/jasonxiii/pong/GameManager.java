package pl.jasonxiii.pong;

public enum GameManager
{
	INSTANCE;

	private GameBoard board;
	private GameUI ui;

	public void setBoard(GameBoard board)
	{
		this.board = board;
	}

	public void setUI(GameUI ui)
	{
		this.ui = ui;
	}

	public GameBoard getBoard()
	{
		return board;
	}

	public void increaseScoreToPlayerOne()
	{
		board.playerOne().increaseScore();

		if(isOver())
		{
			ui.setPlayerWonText("PLAYER 1 WON!");
		}
	}

	public void increaseScoreToPlayerTwo()
	{
		board.playerTwo().increaseScore();

		if(isOver())
		{
			ui.setPlayerWonText("PLAYER 2 WON!");
		}
	}

	public boolean isOver()
	{
		int scoreToWin = Constants.PLAYER_SCORE_TO_WIN;

		return board.playerOne().getScore() == scoreToWin || board.playerTwo().getScore() == scoreToWin;
	}
}