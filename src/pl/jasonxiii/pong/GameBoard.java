package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.interfaces.Updatable;
import pl.jasonxiii.pong.players.Player;

import java.util.ArrayList;

public class GameBoard implements Updatable
{
	private final ArrayList<Player> players;
	private final Ball ball;

	public GameBoard(ArrayList<Player> players, Ball ball)
	{
		this.players = players;
		this.ball = ball;
	}

	@Override
	public void update(double delta)
	{
		if(GameManager.INSTANCE.isOver())
		{
			return;
		}

		players.forEach(p -> p.getPaddle().update(delta));
		ball.update(delta);
	}

	public void addPlayer(Player player)
	{
		players.add(player);
	}

	public void removePlayer(Player player)
	{
		players.remove(player);
	}

	public ArrayList<Player> getPlayers()
	{
		return players;
	}
}