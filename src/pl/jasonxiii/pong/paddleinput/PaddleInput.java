package pl.jasonxiii.pong.paddleinput;

import pl.jasonxiii.pong.gameobjects.Paddle;

public abstract class PaddleInput {
	private Paddle paddle;

	public abstract boolean isMovingUp();
	public abstract boolean isMovingDown();

	public final int movementDirectionY() {
		int y = 0;

		if(isMovingUp()) {
			return -1;
		} else if(isMovingDown()) {
			return 1;
		}

		return y;
	}

	public final void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}

	public final Paddle getPaddle() {
		return paddle;
	}
}