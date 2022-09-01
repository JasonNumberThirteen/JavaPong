package pl.jasonxiii.pong;

import javax.swing.*;

public class GameFrame extends JFrame
{
	public GameFrame()
	{
		add(new GamePanel());
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
}