package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;

public class BoxCollider extends Collider<Rectangle>
{
	public BoxCollider(GameObject object, Rectangle collider)
	{
		super(object, collider);
	}

	public Rectangle collisionBox()
	{
		updateColliderPosition();

		return collider;
	}

	@Override
	public void updateColliderPosition()
	{
		collider.setLocation(object.getPosition());
	}
}