package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;

import java.awt.event.KeyEvent;
import java.util.HashSet;

public class GameObjectsContainer
{
	private final HashSet<Paddle> paddles = new HashSet<>();
	private final Ball ball = new Ball();

	public GameObjectsContainer()
	{
		addPaddles();
	}

	public HashSet<Paddle> getPaddles()
	{
		return paddles;
	}

	public Ball getBall()
	{
		return ball;
	}

	private void addPaddles()
	{
		paddles.add(new Paddle(Constants.PADDLE_WIDTH, new PlayerKeyboardInput(KeyEvent.VK_W, KeyEvent.VK_S)));
		paddles.add(new Paddle(Constants.GAME_WIDTH - Constants.PADDLE_WIDTH - Constants.PADDLE_OFFSET_FROM_EDGE, new PlayerKeyboardInput(KeyEvent.VK_O, KeyEvent.VK_L)));
	}
}