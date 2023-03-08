package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Methods;
import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.interfaces.*;
import pl.jasonxiii.pong.colliders.BoxCollider;
import pl.jasonxiii.pong.paddleinput.PaddleInput;

import java.awt.*;

public class Paddle extends MovingGameObject implements Updatable, Drawable, Collidable {
	private final BoxCollider collider = new BoxCollider(this, new Point(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT));

	private PaddleInput input;

	public Paddle(int x, PaddleInput pi) {
		this(x);
		setInput(pi);
	}

	public Paddle(int x) {
		super(x, Constants.PADDLE_INITIAL_Y);
		getMovementSpeed().setTo(Constants.PADDLE_MOVEMENT_SPEED);
	}

	@Override
	public void update(double delta) {
		getMovementDirection().setDirectionY(input.movementDirectionY());
		move(delta);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Constants.PADDLE_COLOR);
		g.fillRect(getPositionX(), getPositionY(), Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
	}

	@Override
	public void move(double delta) {
		int movementStep = movementStep(delta);
		int max = Constants.GAME_HEIGHT - Constants.PADDLE_HEIGHT;
		int directionY = getMovementDirection().getDirectionY();
		int offset = movementStep*directionY;

		setPositionY(Methods.clampInt(0, getPositionY() + offset, max));
	}

	@Override
	public int hashCode() {
		return getPositionX();
	}

	@Override
	public boolean equals(Object o) {
		if(getClass() != o.getClass()) {
			return false;
		}

		Paddle p = (Paddle) o;

		return getPositionX() == p.getPositionX();
	}

	public final void setInput(PaddleInput pi) {
		input = pi;

		pi.setPaddle(this);
	}

	public final Point center() {
		return collider.center();
	}

	public final BoxCollider getCollider() {
		return collider;
	}

	public final PaddleInput getInput() {
		return input;
	}
}