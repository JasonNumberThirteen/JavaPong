package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.interfaces.Collidable;
import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.*;
import java.awt.geom.Area;

public abstract class Collider<T extends Shape> implements Collidable {
	protected final GameObject object;
	protected final T collider;

	public Collider(GameObject object, T collider) {
		this.object = object;
		this.collider = collider;
	}

	public abstract void updateColliderPosition();
	public abstract Point center();

	public final <U extends Collider<?>> boolean isCollidingWith(U collider) {
		if(collider instanceof BoxCollider bc) {
			return getCollider().intersects(bc.getCollider());
		} else if(collider instanceof CircleCollider cc) {
			Area caa = new Area(getCollider());
			Area cab = new Area(cc.getCollider());

			return caa.intersects(cab.getBounds());
		}

		return false;
	}

	public final T getCollider() {
		updateColliderPosition();

		return collider;
	}
}