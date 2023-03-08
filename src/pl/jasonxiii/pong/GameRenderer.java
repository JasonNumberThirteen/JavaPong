package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;

public final class GameRenderer implements Drawable {
	private final ArrayList<Drawable> drawables = new ArrayList<>();

	public GameRenderer(Drawable... drawables) {
		this.drawables.addAll(Arrays.asList(drawables));
	}

	@Override
	public void draw(Graphics g) {
		for (Drawable d : drawables) {
			d.draw(g);
		}
	}

	public void addDrawable(Drawable drawable) {
		drawables.add(drawable);
	}

	public void removeDrawable(Drawable drawable) {
		drawables.remove(drawable);
	}
}