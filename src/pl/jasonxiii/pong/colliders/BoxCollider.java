package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.gameobjects.GameObject;
import pl.jasonxiii.pong.gameobjects.Paddle;
import pl.jasonxiii.pong.interfaces.Collidable;

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

	@Override
	public <U extends Collider<Rectangle>> boolean isCollidingWith(U collider)
	{
		if(collider instanceof BoxCollider bc)
		{
			return bc.collisionBox().intersects(collisionBox());
		}

		return false;
	}
}