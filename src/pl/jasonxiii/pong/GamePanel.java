package pl.jasonxiii.pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable
{
	private final Thread thread;
	private final Player playerA = new PlayerOne();
	private final Player playerB = new PlayerTwo();
	private final Ball ball = new Ball(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
	private final KeyboardInput input = new KeyboardInput(playerA.getPaddle(), playerB.getPaddle());
	private final UI ui = new UI();

	private boolean isRunning;

	public GamePanel()
	{
		setBackground(Constants.BACKGROUND_COLOR);
		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(input);

		thread = new Thread(this);
		isRunning = true;

		thread.start();
	}

	@Override
	public void run()
	{
		long previousFrame = System.currentTimeMillis();
		long difference;
		long delay;
		int ms = 1000 / Constants.GAME_FPS;

		while (isRunning)
		{
			update();
			repaint();

			difference = System.currentTimeMillis() - previousFrame;
			delay = ms - difference;

			if(delay < 0)
			{
				delay = 2;
			}

			try
			{
				Thread.sleep(delay);
			}
			catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}

			previousFrame = System.currentTimeMillis();
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		playerA.getPaddle().draw(g);
		playerB.getPaddle().draw(g);
		ball.draw(g);
		ui.draw(g);
	}

	private void update()
	{
		playerA.getPaddle().update();
		playerB.getPaddle().update();
		ball.update();
	}
}