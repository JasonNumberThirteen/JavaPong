package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.interfaces.Updatable;

public record GameBoard(Paddle paddleOne, Paddle paddleTwo, Ball ball) implements Updatable
{
	@Override
	public void update()
	{
		paddleOne.update();
		paddleTwo.update();
		ball.update();
	}
}