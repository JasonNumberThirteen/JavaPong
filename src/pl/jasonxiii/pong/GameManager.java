package pl.jasonxiii.pong;

import pl.jasonxiii.pong.counters.IntegerCounter;

public enum GameManager
{
	INSTANCE;

	private final IntegerCounter leftSideScore = new IntegerCounter(Constants.SIDE_INITIAL_SCORE);
	private final IntegerCounter rightSideScore = new IntegerCounter(Constants.SIDE_INITIAL_SCORE);

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

	public void increaseLeftSideScore()
	{
		leftSideScore.increaseBy(1);
		ui.update();
	}

	public void increaseRightSideScore()
	{
		rightSideScore.increaseBy(1);
		ui.update();
	}

	public boolean isOver()
	{
		return leftSideScore.getValue() >= Constants.SIDE_SCORE_TO_WIN || rightSideScore.getValue() >= Constants.SIDE_SCORE_TO_WIN;
	}

	public String wonSide()
	{
		return leftSideScore.getValue() >= Constants.SIDE_SCORE_TO_WIN ? "LEFT" : "RIGHT";
	}

	public IntegerCounter getLeftSideScore()
	{
		return leftSideScore;
	}

	public IntegerCounter getRightSideScore()
	{
		return rightSideScore;
	}
}