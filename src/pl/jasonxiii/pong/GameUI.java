package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.uitexts.PlayerWonText;
import pl.jasonxiii.pong.uitexts.ScoreText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final ScoreText playerOneScoreText, playerTwoScoreText;
	private final PlayerWonText playerWonText = new PlayerWonText();

	public GameUI(ScoreText playerOneScoreText, ScoreText playerTwoScoreText)
	{
		this.playerOneScoreText = playerOneScoreText;
		this.playerTwoScoreText = playerTwoScoreText;
	}

	public void setPlayerWonText(String text)
	{
		playerWonText.setText(text);
	}

	@Override
	public void draw(Graphics g)
	{
		playerOneScoreText.draw(g);
		playerTwoScoreText.draw(g);
		playerWonText.draw(g);
	}
}