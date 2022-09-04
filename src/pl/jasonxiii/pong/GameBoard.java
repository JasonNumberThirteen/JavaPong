package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.interfaces.Updatable;
import pl.jasonxiii.pong.players.Player;

public record GameBoard(Player playerOne, Player playerTwo, Ball ball) implements Updatable
{
	@Override
	public void update(double delta)
	{
		if(GameManager.INSTANCE.isOver())
		{
			return;
		}

		playerOne.getPaddle().update(delta);
		playerTwo.getPaddle().update(delta);
		ball.update(delta);
	}
}