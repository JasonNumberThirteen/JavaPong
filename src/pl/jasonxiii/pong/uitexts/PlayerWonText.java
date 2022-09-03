package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;

import java.awt.*;

public class PlayerWonText extends UIText
{
	public PlayerWonText()
	{
		super("PLAYER 1 WON!", new Point(Constants.GAME_WIDTH >> 1, Constants.GAME_HEIGHT >> 1), Color.ORANGE);
	}

	@Override
	public boolean isVisible()
	{
		return GameManager.INSTANCE.isOver();
	}
}