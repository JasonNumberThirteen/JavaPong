package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;

import java.awt.*;

public class PlayerWonText extends UIText
{
	public PlayerWonText()
	{
		super(new Point(Constants.HALF_OF_GAME_WIDTH, Constants.HALF_OF_GAME_HEIGHT), Constants.SIDE_WON_TEXT_COLOR);
	}

	@Override
	public boolean isVisible()
	{
		return GameManager.INSTANCE.isOver();
	}
}