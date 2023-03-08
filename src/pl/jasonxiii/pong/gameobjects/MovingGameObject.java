package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.MovementDirection;
import pl.jasonxiii.pong.counters.IntegerCounter;

public abstract class MovingGameObject extends GameObject {
	private final MovementDirection movementDirection = new MovementDirection();
	private final IntegerCounter movementSpeed = new IntegerCounter();

	public MovingGameObject(int x, int y) {
		super(x, y);
	}

	public abstract void move(double delta);

	public final int movementStep(double delta) {
		return (int)(movementSpeed.getValue()*delta);
	}

	public final MovementDirection getMovementDirection() {
		return movementDirection;
	}

	public final IntegerCounter getMovementSpeed() {
		return movementSpeed;
	}
}