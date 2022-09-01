package pl.jasonxiii.pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable
{
	public GamePanel()
	{
		setBackground(Constants.BACKGROUND_COLOR);
		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
	}

	@Override
	public void run()
	{

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}