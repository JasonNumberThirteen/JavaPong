package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;

public class UIText implements Drawable
{
	private final StringBuilder stringBuilder;
	private final Point position;
	private final Color color;

	public UIText(String text, Point position, Color color)
	{
		this.stringBuilder = new StringBuilder(text);
		this.position = position;
		this.color = color;
	}

	public void setText(String text)
	{
		stringBuilder.replace(0, stringBuilder.length(), text);
	}

	public void setX(int x)
	{
		position.x = x;
	}

	public void setY(int y)
	{
		position.y = y;
	}

	public boolean isVisible()
	{
		return true;
	}

	@Override
	public void draw(Graphics g)
	{
		if(!isVisible())
		{
			return;
		}

		Graphics2D g2D = (Graphics2D)g;

		g.setColor(color);
		g.setFont(textFont());
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString(stringBuilder.toString(), position.x, position.y);
	}

	private Font textFont()
	{
		return new Font(Font.SERIF, Font.BOLD, Constants.UI_FONT_SIZE);
	}
}