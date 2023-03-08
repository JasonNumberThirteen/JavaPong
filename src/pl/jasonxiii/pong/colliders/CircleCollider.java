package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;
import java.awt.geom.Arc2D;

public class CircleCollider extends Collider<Arc2D> {
	private final int radius;

	public CircleCollider(GameObject object, Arc2D collider, int radius) {
		super(object, collider);

		this.radius = radius;
	}

	@Override
	public void updateColliderPosition() {
		Point position = object.getPosition();

		collider.setArc(position.x, position.y, radius, radius, 0, 360, Arc2D.CHORD);
	}

	@Override
	public Point center() {
		int halfOfRadius = radius >> 1;
		int x = object.getPositionX() + halfOfRadius;
		int y = object.getPositionY() + halfOfRadius;

		return new Point(x, y);
	}
}