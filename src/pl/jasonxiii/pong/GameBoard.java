package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Updatable;
import pl.jasonxiii.pong.gameobjects.Ball;
import pl.jasonxiii.pong.gameobjects.Paddle;

import java.util.HashSet;

public record GameBoard(HashSet<Paddle> paddles, Ball ball) implements Updatable {
	@Override
	public void update(double delta) {
		if(GameManager.INSTANCE.isOver()) {
			return;
		}

		paddles.forEach(p -> p.update(delta));
		ball.update(delta);
	}

	public void addPaddle(Paddle paddle) {
		paddles.add(paddle);
	}

	public void removePaddle(Paddle paddle) {
		paddles.remove(paddle);
	}
}