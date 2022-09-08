package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;

public class BoxCollider extends Collider<Rectangle>
{
	public BoxCollider(GameObject object, Rectangle collider)
	{
		super(object, collider);
	}

	@Override
	public void updateColliderPosition()
	{
		collider.setLocation(object.getPosition());
	}

	@Override
	public <U extends Collider<Rectangle>> boolean isCollidingWith(U collider)
	{
		if(collider instanceof BoxCollider bc)
		{
			return bc.getCollider().intersects(getCollider());
		}

		return false;
	}
}