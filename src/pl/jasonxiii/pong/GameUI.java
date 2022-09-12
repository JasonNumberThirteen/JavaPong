package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.players.Player;
import pl.jasonxiii.pong.uitexts.PlayerWonText;
import pl.jasonxiii.pong.uitexts.ScoreText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final ScoreText playerOneScoreText = new ScoreText(new Point((Constants.GAME_WIDTH >> 1) - 48, Constants.SCORE_TEXT_Y));
	private final ScoreText playerTwoScoreText = new ScoreText(new Point((Constants.GAME_WIDTH >> 1) + 48, Constants.SCORE_TEXT_Y));
	private final PlayerWonText playerWonText = new PlayerWonText();

	public GameUI(Player playerOne, Player playerTwo)
	{
		playerOneScoreText.setPlayer(playerOne);
		playerTwoScoreText.setPlayer(playerTwo);
	}

	@Override
	public void draw(Graphics g)
	{
		playerOneScoreText.draw(g);
		playerTwoScoreText.draw(g);
		playerWonText.draw(g);
	}

	public void update()
	{
		playerOneScoreText.updateText();
		playerTwoScoreText.updateText();
		updatePlayerWonText();
	}

	private void updatePlayerWonText()
	{
		GameManager gm = GameManager.INSTANCE;

		if(gm.isOver())
		{
			playerWonText.setText(String.format("PLAYER %d WON!", gm.wonPlayerNumber()));
		}
	}
}