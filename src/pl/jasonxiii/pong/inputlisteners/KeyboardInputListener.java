package pl.jasonxiii.pong.inputlisteners;

import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.paddleinput.PaddleInput;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;

public class KeyboardInputListener extends InputListener implements KeyListener
{
	private final ArrayList<KeyListener> listeners = new ArrayList<>();

	public KeyboardInputListener(HashSet<Paddle> paddles)
	{
		addFoundKeyListeners(paddles);
	}

	@Override
	public void enable(JPanel panel)
	{
		panel.addKeyListener(this);
	}

	@Override
	public void disable(JPanel panel)
	{
		panel.removeKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{
		listeners.forEach(l -> l.keyTyped(ke));
	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		listeners.forEach(l -> l.keyPressed(ke));
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		listeners.forEach(l -> l.keyReleased(ke));
	}

	private void addFoundKeyListeners(HashSet<Paddle> paddles)
	{
		ArrayList<KeyListener> keyListeners = new ArrayList<>();

		for (Paddle p : paddles)
		{
			PaddleInput pi = p.getInput();

			if(pi instanceof KeyListener)
			{
				keyListeners.add((KeyListener)pi);
			}
		}

		listeners.addAll(keyListeners);
	}
}