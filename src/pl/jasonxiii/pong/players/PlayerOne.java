package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.PlayerInput;

import java.awt.event.KeyEvent;

public class PlayerOne extends Player
{
	public PlayerOne()
	{
		super(Constants.PADDLE_WIDTH, new PlayerInput(KeyEvent.VK_W, KeyEvent.VK_S), (Constants.GAME_WIDTH >> 1) - 48);
	}
}