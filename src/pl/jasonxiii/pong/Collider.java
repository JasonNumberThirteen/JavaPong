package pl.jasonxiii.pong;

import pl.jasonxiii.pong.gameobjects.GameObject;
import pl.jasonxiii.pong.interfaces.Collidable;

import java.awt.*;

public abstract class Collider implements Collidable
{
	protected final GameObject object;

	private final Shape collider;

	public Collider(GameObject object, Shape collider)
	{
		this.object = object;
		this.collider = collider;
	}

	public abstract void updateColliderPosition();
}