package pl.jasonxiii.pong;

import java.awt.event.KeyEvent;

public class PlayerOne extends Player
{
	public PlayerOne()
	{
		super(Constants.PADDLE_WIDTH, KeyEvent.VK_W, KeyEvent.VK_S);
	}
}