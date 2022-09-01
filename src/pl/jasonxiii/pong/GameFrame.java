package pl.jasonxiii.pong;

import javax.swing.*;

public class GameFrame extends JFrame
{
	public GameFrame()
	{
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(640, 480);
		setLocationRelativeTo(null);
	}
}