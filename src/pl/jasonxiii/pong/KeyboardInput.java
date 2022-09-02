package pl.jasonxiii.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyboardInput implements KeyListener
{
	private final ArrayList<KeyListener> listeners = new ArrayList<>();

	public KeyboardInput(KeyListener... listeners)
	{
		this.listeners.addAll(Arrays.asList(listeners));
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
}