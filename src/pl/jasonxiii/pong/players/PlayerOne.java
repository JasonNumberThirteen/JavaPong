package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;

import java.awt.event.KeyEvent;

public class PlayerOne extends Player
{
	public PlayerOne()
	{
		super(Constants.PADDLE_WIDTH, KeyEvent.VK_W, KeyEvent.VK_S);
	}
}