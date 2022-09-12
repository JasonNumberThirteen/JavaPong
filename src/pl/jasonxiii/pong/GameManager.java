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
	}

	public boolean isOver()
	{
		return board.playerOne().wonTheGame() || board.playerTwo().wonTheGame();
	}

	public int wonPlayerNumber()
	{
		if(board.playerOne().wonTheGame())
		{
			return 1;
		}
		else if(board.playerTwo().wonTheGame())
		{
			return 2;
		}

		return 0;
	}
}