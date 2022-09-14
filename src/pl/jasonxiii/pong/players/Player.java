package pl.jasonxiii.pong.players;

import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;

public class Player
{
	private final Paddle paddle;

	public Player(int x, PlayerKeyboardInput input)
	{
		paddle = new Paddle(x, input);
	}

	public Paddle getPaddle()
	{
		return paddle;
	}
}