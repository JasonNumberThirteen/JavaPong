package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.playerinput.PlayerKeyboardInput;

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
		assignSidesScoreToTexts();
	}

	public HashSet<Paddle> getPaddles()
	{
		return paddles;
	}

	public GameBoard getBoard()
	{
		return board;
	}

	public GameRenderer getRenderer()
	{
		return renderer;
	}

	private void addPaddles()
	{
		paddles.add(new Paddle(Constants.PADDLE_WIDTH, new PlayerKeyboardInput(KeyEvent.VK_W, KeyEvent.VK_S)));
		paddles.add(new Paddle(Constants.GAME_WIDTH - Constants.PADDLE_WIDTH - Constants.PADDLE_OFFSET_FROM_EDGE, new PlayerKeyboardInput(KeyEvent.VK_O, KeyEvent.VK_L)));
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

	private void assignSidesScoreToTexts()
	{
		GameManager gm = GameManager.INSTANCE;

		ui.setCounterToLeftSideScoreText(gm.getLeftSideScore());
		ui.setCounterToRightSideScoreText(gm.getRightSideScore());
	}
}