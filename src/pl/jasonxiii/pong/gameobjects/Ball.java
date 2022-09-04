package pl.jasonxiii.pong.gameobjects;

import pl.jasonxiii.pong.Constants;
import pl.jasonxiii.pong.GameManager;
import pl.jasonxiii.pong.interfaces.Drawable;
import pl.jasonxiii.pong.interfaces.Updatable;

import java.awt.*;

public class Ball extends GameObject implements Updatable, Drawable
{
	private int directionX;
	private int directionY;

	public Ball()
	{
		super(Constants.BALL_INITIAL_X, Constants.BALL_INITIAL_Y);
		randomiseDirection();
	}

	@Override
	public void update(double delta)
	{
		int movementSpeed = Constants.BALL_INITIAL_MOVEMENT_SPEED;

		position.x += movementSpeed*directionX;
		position.y += movementSpeed*directionY;

		if(position.y <= 0 || position.y >= Constants.GAME_HEIGHT - Constants.BALL_RADIUS)
		{
			directionY = -directionY;
		}
		else if(position.x >= Constants.GAME_WIDTH)
		{
			GameManager.INSTANCE.increaseScoreToPlayerOne();
			resetPosition();
			randomiseDirection();
		}
		else if(position.x <= -Constants.BALL_RADIUS)
		{
			GameManager.INSTANCE.increaseScoreToPlayerTwo();
			resetPosition();
			randomiseDirection();
		}
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;

		g.setColor(Constants.BALL_COLOR);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillArc(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_RADIUS, 0, 360);
	}

	private void randomiseDirection()
	{
		directionX = Math.random() < 0.5 ? -1 : 1;
		directionY = Math.random() < 0.5 ? -1 : 1;
	}

	private void resetPosition()
	{
		position.x = Constants.BALL_INITIAL_X;
		position.y = Constants.BALL_INITIAL_Y;
	}
}