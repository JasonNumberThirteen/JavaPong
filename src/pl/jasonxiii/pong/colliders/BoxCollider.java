package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;

public class BoxCollider extends Collider<Rectangle>
{
	public BoxCollider(GameObject object, Point size)
	{
		super(object, new Rectangle(object.getPositionX(), object.getPositionY(), size.x, size.y));
	}

	@Override
	public void updateColliderPosition()
	{
		collider.setLocation(object.getPosition());
	}
}