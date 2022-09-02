package pl.jasonxiii.pong;

import java.awt.*;

public class UI implements Drawable
{
	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;

		g.setColor(Color.WHITE);
		g.setFont(uiFont());
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString("0", (Constants.GAME_WIDTH >> 1) - 48, Constants.UI_FONT_SIZE);
		g.drawString("0", (Constants.GAME_WIDTH >> 1) + 48, Constants.UI_FONT_SIZE);
	}

	private Font uiFont()
	{
		return new Font(Font.SERIF, Font.BOLD, Constants.UI_FONT_SIZE);
	}
}