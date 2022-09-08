package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.geom.Arc2D;

public class CircleCollider extends Collider<Arc2D>
{
	public CircleCollider(GameObject object, Arc2D collider)
	{
		super(object, collider);
	}

	@Override
	public void updateColliderPosition()
	{
		collider.setArc(object.getPosition().x, object.getPosition().y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360, Arc2D.CHORD);
	}
}