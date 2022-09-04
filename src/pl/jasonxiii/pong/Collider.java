package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.GameObject;
import pl.jasonxiii.pong.interfaces.Collidable;

import java.awt.*;

public abstract class Collider<T extends Shape> implements Collidable
{
	protected final GameObject object;
	protected final T collider;

	public Collider(GameObject object, T collider)
	{
		this.object = object;
		this.collider = collider;
	}

	public abstract void updateColliderPosition();
}