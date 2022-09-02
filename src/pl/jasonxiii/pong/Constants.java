package pl.jasonxiii.pong;

import java.awt.*;

public final class Constants
{
	public static final String GAME_TITLE = "Pong";
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final int GAME_FPS = 60;

	public static final Color BACKGROUND_COLOR = Color.BLACK;

	public static final int PADDLE_WIDTH = 8;
	public static final int PADDLE_HEIGHT = 32;
	public static final int PADDLE_OFFSET_FROM_EDGE = 8;
	public static final int PADDLE_MOVEMENT_SPEED = 3;
	public static final Color PADDLE_COLOR = Color.WHITE;

	public static final int BALL_RADIUS = 16;
	public static final int BALL_INITIAL_X = (GAME_WIDTH - BALL_RADIUS) >> 1;
	public static final int BALL_INITIAL_Y = (GAME_HEIGHT - BALL_RADIUS) >> 1;
	public static final int BALL_INITIAL_MOVEMENT_SPEED = 2;
	public static final Color BALL_COLOR = Color.WHITE;

	public static final int UI_FONT_SIZE = 32;
}