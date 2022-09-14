package pl.jasonxiii.pong;

import pl.jasonxiii.pong.counters.IntegerCounter;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.uitexts.SideWonText;
import pl.jasonxiii.pong.uitexts.ScoreText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final ScoreText leftSideScoreText = new ScoreText(new Point(Constants.LEFT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y));
	private final ScoreText rightSideScoreText = new ScoreText(new Point(Constants.RIGHT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y));
	private final SideWonText sideWonText = new SideWonText();

	@Override
	public void draw(Graphics g)
	{
		leftSideScoreText.draw(g);
		rightSideScoreText.draw(g);
		sideWonText.draw(g);
	}

	public void update()
	{
		leftSideScoreText.updateText();
		rightSideScoreText.updateText();
		updateSideWonText();
	}

	public void setCounterToLeftSideScoreText(IntegerCounter ic)
	{
		leftSideScoreText.setCounter(ic);
	}

	public void setCounterToRightSideScoreText(IntegerCounter ic)
	{
		rightSideScoreText.setCounter(ic);
	}

	private void updateSideWonText()
	{
		GameManager gm = GameManager.INSTANCE;

		if(gm.isOver())
		{
			sideWonText.setText(String.format(Constants.SIDE_WON_TEXT_STRING, gm.wonSide()));
		}
	}
}