package pl.jasonxiii.pong.colliders;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.gameobjects.GameObject;

import java.awt.geom.Area;
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

	@Override
	public <U extends Collider<?>> boolean isCollidingWith(U collider)
	{
		if(collider instanceof BoxCollider bc)
		{
			return getCollider().intersects(bc.getCollider());
		}
		else if(collider instanceof CircleCollider cc)
		{
			Area caa = new Area(getCollider());
			Area cab = new Area(cc.getCollider());

			return caa.intersects(cab.getBounds());
		}

		return false;
	}
}