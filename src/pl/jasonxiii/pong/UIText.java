package pl.jasonxiii.pong;

import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;

public class UIText implements Drawable
{
	private final String text;
	private final Color color;

	public UIText(String text, Color color)
	{
		this.text = text;
		this.color = color;
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;
		Point position = textPosition();

		g.setColor(color);
		g.setFont(textFont());
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString(text, position.x, position.y);
	}

	private Font textFont()
	{
		return new Font(Font.SERIF, Font.BOLD, Constants.UI_FONT_SIZE);
	}

	private Point textPosition()
	{
		return new Point(0, 0);
	}
}