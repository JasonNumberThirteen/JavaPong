package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Collidable;

import java.awt.*;

public abstract class Collider implements Collidable
{
	private final Shape collider;

	public Collider(Shape collider)
	{
		this.collider = collider;
	}
}