package pl.jasonxiii.pong;

import java.awt.event.KeyEvent;

public class PlayerTwo extends Player
{
	public PlayerTwo()
	{
		super(Constants.GAME_WIDTH - Constants.PADDLE_WIDTH - Constants.PADDLE_OFFSET_FROM_EDGE, KeyEvent.VK_O, KeyEvent.VK_L);
	}
}