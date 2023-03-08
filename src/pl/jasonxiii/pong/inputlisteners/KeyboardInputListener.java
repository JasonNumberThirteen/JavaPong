package pl.jasonxiii.pong.inputlisteners;

import pl.jasonxiii.pong.gameobjects.Paddle;

import java.util.HashSet;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KeyboardInputListener extends InputListener implements KeyListener {
	private final ArrayList<KeyListener> listeners = new ArrayList<>();

	public KeyboardInputListener(HashSet<Paddle> paddles) {
		listeners.addAll(paddles.stream().filter(p -> p.getInput() instanceof KeyListener).map(p -> (KeyListener)p.getInput()).toList());
	}

	@Override
	public void enable(JPanel panel) {
		panel.addKeyListener(this);
	}

	@Override
	public void disable(JPanel panel) {
		panel.removeKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		listeners.forEach(l -> l.keyTyped(ke));
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		listeners.forEach(l -> l.keyPressed(ke));
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		listeners.forEach(l -> l.keyReleased(ke));
	}
}