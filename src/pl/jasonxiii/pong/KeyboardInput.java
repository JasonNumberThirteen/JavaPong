package pl.jasonxiii.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		System.out.println("Pressed " + ke.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		System.out.println("Released " + ke.getKeyCode());
	}
}