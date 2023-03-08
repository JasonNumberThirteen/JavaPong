package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;

import java.awt.*;

public class SideWonText extends UIText {
	public SideWonText() {
		super(new Point(Constants.HALF_OF_GAME_WIDTH, Constants.HALF_OF_GAME_HEIGHT), Constants.SIDE_WON_TEXT_COLOR);
	}

	@Override
	public void update() {
		GameManager gm = GameManager.INSTANCE;

		if(gm.isOver()) {
			setText(String.format(Constants.SIDE_WON_TEXT_STRING, gm.wonSide()));
		}
	}

	@Override
	public boolean isVisible() {
		return GameManager.INSTANCE.isOver();
	}
}