package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;

public class BoxCollider extends Collider
{
	private final Rectangle collider;

	public BoxCollider(GameObject object, Rectangle collider)
	{
		super(object, collider);

		this.collider = collider;
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