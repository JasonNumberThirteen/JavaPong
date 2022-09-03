package pl.jasonxiii.pong;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable
{
	private final Thread thread;
	private final Player playerA = new PlayerOne();
	private final Player playerB = new PlayerTwo();
	private final Ball ball = new Ball();
	private final KeyboardInput input = new KeyboardInput(playerA.getPaddle(), playerB.getPaddle());
	private final UI ui = new UI(playerA, playerB);
	private final ArrayList<Updatable> updatables = new ArrayList<>(Arrays.asList(playerA.getPaddle(), playerB.getPaddle(), ball));
	private final ArrayList<Drawable> drawables = new ArrayList<>(Arrays.asList(playerA.getPaddle(), playerB.getPaddle(), ball, ui));

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
		drawables.forEach(d -> d.draw(g));
	}

	private void update()
	{
		updatables.forEach(Updatable::update);
	}
}