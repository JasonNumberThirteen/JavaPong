package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.players.Player;

import java.awt.*;

public class ScoreText extends UIText
{
	private Player player;

	public ScoreText(Point position)
	{
		super(String.valueOf(Constants.PLAYER_INITIAL_SCORE), position, Constants.SCORE_TEXT_COLOR);
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public void updateText()
	{
		setText(String.valueOf(player.getScore()));
	}
}