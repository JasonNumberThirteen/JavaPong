package pl.jasonxiii.pong;

import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.uitexts.PlayerWonText;
import pl.jasonxiii.pong.uitexts.ScoreText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final ScoreText leftSideScoreText = new ScoreText(new Point(Constants.LEFT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y));
	private final ScoreText rightSideScoreText = new ScoreText(new Point(Constants.RIGHT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y));
	private final PlayerWonText playerWonText = new PlayerWonText();

	@Override
	public void draw(Graphics g)
	{
		leftSideScoreText.draw(g);
		rightSideScoreText.draw(g);
		playerWonText.draw(g);
	}

	public void update()
	{
		leftSideScoreText.updateText();
		rightSideScoreText.updateText();
		updatePlayerWonText();
	}

	public void setCounterToLeftSideScoreText(IntegerCounter ic)
	{
		leftSideScoreText.setCounter(ic);
	}

	public void setCounterToRightSideScoreText(IntegerCounter ic)
	{
		rightSideScoreText.setCounter(ic);
	}

	private void updatePlayerWonText()
	{
		GameManager gm = GameManager.INSTANCE;

		if(gm.isOver())
		{
			playerWonText.setText(String.format(Constants.SIDE_WON_TEXT_STRING, gm.wonSide()));
		}
	}
}