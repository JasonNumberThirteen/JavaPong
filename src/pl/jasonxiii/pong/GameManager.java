package pl.jasonxiii.pong;

import pl.jasonxiii.pong.players.Player;

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

	public void increasePlayerScore(Player player)
	{
		player.increaseScore();

		if(isOver())
		{
			ui.setPlayerWonText(String.format("PLAYER %d WON!", player.getNumber()));
		}
	}

	public boolean isOver()
	{
		int scoreToWin = Constants.PLAYER_SCORE_TO_WIN;

		return board.playerOne().getScore() == scoreToWin || board.playerTwo().getScore() == scoreToWin;
	}
}