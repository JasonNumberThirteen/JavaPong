package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.players.Player;
import pl.jasonxiii.pong.uitexts.PlayerWonText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final Player[] players;
	private final PlayerWonText playerWonText = new PlayerWonText();

	public GameUI(Player... players)
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

		playerWonText.draw(g);
	}
}