package pl.jasonxiii.pong.window;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.interfaces.Updatable;
import pl.jasonxiii.pong.players.Player;
import pl.jasonxiii.pong.players.PlayerOne;
import pl.jasonxiii.pong.players.PlayerTwo;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, Updatable
{
	private final Player playerA = new PlayerOne();
	private final Player playerB = new PlayerTwo();
	private final Ball ball = new Ball();
	private final KeyboardInput input = new KeyboardInput(playerA.getPaddle(), playerB.getPaddle());
	private final GameUI ui = new GameUI(playerA.getScoreText(), playerB.getScoreText());
	private final GameBoard board = new GameBoard(playerA, playerB, ball);
	private final GameRenderer renderer = new GameRenderer(playerA.getPaddle(), playerB.getPaddle(), ball, ui);

	private boolean isRunning = true;

	public GamePanel()
	{
		setBackground(Constants.BACKGROUND_COLOR);
		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(input);
		assignDependenciesToGameManager();
		start();
	}

	@Override
	public void run()
	{
		long previousFrame = System.currentTimeMillis();
		int ms = 1000 / Constants.GAME_FPS;
		double delta = 1.0 / Constants.GAME_FPS;

		while (isRunning)
		{
			update(delta);
			repaint();

			try
			{
				Thread.sleep(delay(ms, difference(previousFrame)));
			}
			catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}

			previousFrame = System.currentTimeMillis();
		}
	}

	@Override
	public void update(double delta)
	{
		board.update(delta);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		renderer.draw(g);
	}

	private void assignDependenciesToGameManager()
	{
		GameManager gm = GameManager.INSTANCE;

		gm.setBoard(board);
		gm.setUI(ui);
	}

	private void start()
	{
		Thread thread = new Thread(this);

		thread.start();
	}

	private long difference(long previousFrame)
	{
		return System.currentTimeMillis() - previousFrame;
	}

	private long delay(int ms, long difference)
	{
		long d = ms - difference;

		return d < 0 ? 2 : d;
	}
}