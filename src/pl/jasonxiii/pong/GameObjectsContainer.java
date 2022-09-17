package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.paddleinput.PaddleCPUInput;
import pl.jasonxiii.pong.paddleinput.PaddleKeyboardInput;
import pl.jasonxiii.pong.uitexts.ScoreText;
import pl.jasonxiii.pong.uitexts.SideWonText;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class GameObjectsContainer
{
	private final HashSet<Paddle> paddles = new HashSet<>();
	private final Ball ball = new Ball();
	private final GameUI ui = new GameUI();
	private final GameBoard board = new GameBoard(paddles, ball);
	private final GameRenderer renderer = new GameRenderer();

	public GameObjectsContainer()
	{
		addPaddles();
		assignDependenciesToGameManager();
		addDrawablesToRenderer();
		addUITexts();
	}

	public final HashSet<Paddle> getPaddles()
	{
		return paddles;
	}

	public final Ball getBall()
	{
		return ball;
	}

	public final GameBoard getBoard()
	{
		return board;
	}

	public final GameRenderer getRenderer()
	{
		return renderer;
	}

	private void addPaddles()
	{
		PaddleKeyboardInput leftPaddleInput = new PaddleKeyboardInput(KeyEvent.VK_W, KeyEvent.VK_S);
		PaddleCPUInput rightPaddleInput = new PaddleCPUInput();
		Paddle leftPaddle = new Paddle(Constants.PADDLE_WIDTH, leftPaddleInput);
		Paddle rightPaddle = new Paddle(Constants.GAME_WIDTH - Constants.PADDLE_WIDTH - Constants.PADDLE_OFFSET_FROM_EDGE, rightPaddleInput);

		paddles.add(leftPaddle);
		paddles.add(rightPaddle);
	}

	private void assignDependenciesToGameManager()
	{
		GameManager gm = GameManager.INSTANCE;

		gm.setBoard(board);
		gm.setUI(ui);
	}

	private void addDrawablesToRenderer()
	{
		paddles.forEach(renderer::addDrawable);
		renderer.addDrawable(ball);
		renderer.addDrawable(ui);
	}

	private void addUITexts()
	{
		GameManager gm = GameManager.INSTANCE;
		Point leftSideScorePoint = new Point(Constants.LEFT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y);
		Point rightSideScorePoint = new Point(Constants.RIGHT_SIDE_SCORE_X, Constants.SIDE_SCORE_TEXT_Y);

		ui.addText(new ScoreText(leftSideScorePoint, gm.getLeftSideScore()));
		ui.addText(new ScoreText(rightSideScorePoint, gm.getRightSideScore()));
		ui.addText(new SideWonText());
	}
}