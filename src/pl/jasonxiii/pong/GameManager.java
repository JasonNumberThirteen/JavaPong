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

	public IntegerCounter getLeftSideScore()
	{
		return leftSideScore;
	}

	public IntegerCounter getRightSideScore()
	{
		return rightSideScore;
	}

	public GameBoard getBoard()
	{
		return board;
	}

	public void increaseLeftSideScore()
	{
		leftSideScore.increaseBy(Constants.SIDE_POINTS_PER_BALL_ESCAPE);
		ui.update();
	}

	public void increaseRightSideScore()
	{
		rightSideScore.increaseBy(Constants.SIDE_POINTS_PER_BALL_ESCAPE);
		ui.update();
	}

	public boolean isOver()
	{
		int sideScoreToWin = Constants.SIDE_SCORE_TO_WIN;

		return leftSideScore.isGreaterThanOrEqualTo(sideScoreToWin) || rightSideScore.isGreaterThanOrEqualTo(sideScoreToWin);
	}

	public String wonSide()
	{
		return leftSideScore.isGreaterThanOrEqualTo(Constants.SIDE_SCORE_TO_WIN) ? Constants.LEFT_SIDE_STRING : Constants.RIGHT_SIDE_STRING;
	}
}