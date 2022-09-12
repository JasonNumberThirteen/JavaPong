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
		ui.update();

		if(isOver())
		{
			ui.setPlayerWonText(String.format("PLAYER %d WON!", player.getNumber()));
		}
	}

	public boolean isOver()
	{
		return board.playerOne().wonTheGame() || board.playerTwo().wonTheGame();
	}
}