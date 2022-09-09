package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.geom.Arc2D;

public class CircleCollider extends Collider<Arc2D>
{
	private final int radius;

	public CircleCollider(GameObject object, Arc2D collider, int radius)
	{
		super(object, collider);

		this.radius = radius;
	}

	@Override
	public void updateColliderPosition()
	{
		collider.setArc(object.getPosition().x, object.getPosition().y, radius, radius, 0, 360, Arc2D.CHORD);
	}
}