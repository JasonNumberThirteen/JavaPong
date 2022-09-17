package pl.jasonxiii.pong;

import pl.jasonxiii.pong.uitexts.UIText;
import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;

public final class GameUI implements Drawable
{
	private final ArrayList<UIText> texts = new ArrayList<>();

	public GameUI(UIText... texts)
	{
		this.texts.addAll(Arrays.asList(texts));
	}

	@Override
	public void draw(Graphics g)
	{
		texts.forEach(t -> t.draw(g));
	}

	public void update()
	{
		texts.forEach(UIText::update);
	}

	public void addText(UIText text)
	{
		texts.add(text);
	}

	public void removeText(UIText text)
	{
		texts.remove(text);
	}
}