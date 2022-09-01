package pl.jasonxiii.pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable
{
	public GamePanel()
	{
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(640, 480));
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