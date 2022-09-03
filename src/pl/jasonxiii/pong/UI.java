package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.players.Player;

import java.awt.*;

public class UI implements Drawable
{
	private final Player[] players;

	public UI(Player... players)
	{
		this.players = players;
	}

	@Override
	public void draw(Graphics g)
	{
		for (Player p : players)
		{
			p.getScoreText().draw(g);
		}
	}
}