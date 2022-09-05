package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRenderer implements Drawable
{
	private final ArrayList<Drawable> drawables = new ArrayList<>();

	public GameRenderer(Drawable... drawables)
	{
		this.drawables.addAll(Arrays.asList(drawables));
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