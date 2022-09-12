package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.players.Player;
import pl.jasonxiii.pong.uitexts.PlayerWonText;
import pl.jasonxiii.pong.uitexts.ScoreText;

import java.awt.*;

public class GameUI implements Drawable
{
	private final ScoreText playerOneScoreText = new ScoreText(new Point(Constants.PLAYER_ONE_SCORE_X, Constants.SCORE_TEXT_Y));
	private final ScoreText playerTwoScoreText = new ScoreText(new Point(Constants.PLAYER_TWO_SCORE_X, Constants.SCORE_TEXT_Y));
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
			playerWonText.setText(String.format(Constants.PLAYER_WON_TEXT_STRING, gm.wonPlayerNumber()));
		}
	}
}