package pl.jasonxiii.pong.uitexts;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.interfaces.Drawable;

import java.awt.*;

public class UIText implements Drawable
{
	private final StringBuilder stringBuilder = new StringBuilder();

	private Point position;
	private Color color;

	public UIText(String text, Point position, Color color)
	{
		setText(text);
		setPosition(position);
		setColor(color);
	}

	public UIText(Point position, Color color)
	{
		setPosition(position);
		setColor(color);
	}

	public void setText(String text)
	{
		stringBuilder.replace(0, stringBuilder.length(), text);
	}

	public void setPosition(Point position)
	{
		this.position = position;
	}

	public void setColor(Color color)
	{
		this.color = color;
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
		drawCenteredString(g);
	}

	private void drawCenteredString(Graphics g)
	{
		FontMetrics fm = g.getFontMetrics(textFont());
		String text = stringBuilder.toString();
		int width = fm.stringWidth(text);
		int height = (int)fm.getStringBounds(text, g).getHeight();
		int x = position.x - (width >> 1);
		int y = position.y - (height >> 1);

		g.drawString(text, x, y);
	}

	private Font textFont()
	{
		return new Font(Font.SERIF, Font.BOLD, Constants.UI_FONT_SIZE);
	}
}