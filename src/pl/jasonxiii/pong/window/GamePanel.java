package pl.jasonxiii.pong.window;

import pl.jasonxiii.pong.*;
import pl.jasonxiii.pong.inputlisteners.*;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, Updatable
{
	private final GameObjectsContainer container = new GameObjectsContainer();

	private boolean isRunning = true;

	public GamePanel()
	{
		setBackground(Constants.BACKGROUND_COLOR);
		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		enableInput();
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
		container.getBoard().update(delta);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		container.getRenderer().draw(g);
	}

	private void enableInput()
	{
		InputListener inputListener = new KeyboardInputListener(container.getPaddles());

		inputListener.enable(this);
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