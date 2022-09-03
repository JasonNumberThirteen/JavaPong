package pl.jasonxiii.pong;

import pl.jasonxiii.pong.window.GameFrame;

import java.awt.*;

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(GameFrame::new);
	}
}