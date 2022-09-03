package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;

public class GameRenderer implements Drawable
{
	private final Drawable[] drawables;

	public GameRenderer(Drawable... drawables)
	{
		this.drawables = drawables;
	}

	@Override
	public void draw(Graphics g)
	{
		for (Drawable d : drawables)
		{
			d.draw(g);
		}
	}
}