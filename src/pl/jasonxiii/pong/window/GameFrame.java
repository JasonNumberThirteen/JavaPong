package pl.jasonxiii.pong.window;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameObjectsContainer;
import pl.jasonxiii.pong.inputlisteners.InputListener;
import pl.jasonxiii.pong.inputlisteners.KeyboardInputListener;

import javax.swing.*;

public class GameFrame extends JFrame {
	public GameFrame() {
		add(gamePanel());
		setTitle(Constants.GAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private GamePanel gamePanel() {
		GameObjectsContainer goc = new GameObjectsContainer();
		InputListener il = new KeyboardInputListener(goc.getPaddles());

		return new GamePanel(goc, il);
	}
}