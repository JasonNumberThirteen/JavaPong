package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;

import java.awt.event.KeyEvent;

public class PlayerTwo extends Player
{
	public PlayerTwo()
	{
		super(Constants.GAME_WIDTH - Constants.PADDLE_WIDTH - Constants.PADDLE_OFFSET_FROM_EDGE, new PlayerKeyboardInput(KeyEvent.VK_O, KeyEvent.VK_L));
	}
}