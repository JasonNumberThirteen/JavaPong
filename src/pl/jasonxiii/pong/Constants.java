package pl.jasonxiii.pong;

import java.awt.*;

public final class Constants
{
	public static final String GAME_TITLE = "Pong";
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final int HALF_OF_GAME_WIDTH = GAME_WIDTH >> 1;
	public static final int HALF_OF_GAME_HEIGHT = GAME_HEIGHT >> 1;
	public static final int GAME_FPS = 60;

	public static final Color BACKGROUND_COLOR = Color.BLACK;

	public static final int PLAYER_INITIAL_SCORE = 0;
	public static final int PLAYER_SCORE_TO_WIN = 11;

	public static final int PADDLE_WIDTH = 8;
	public static final int PADDLE_HEIGHT = 32;
	public static final int PADDLE_INITIAL_Y = (GAME_HEIGHT - PADDLE_HEIGHT) >> 1;
	public static final int PADDLE_OFFSET_FROM_EDGE = 8;
	public static final int PADDLE_MOVEMENT_SPEED = 180;
	public static final Color PADDLE_COLOR = Color.WHITE;

	public static final int BALL_RADIUS = 16;
	public static final int BALL_INITIAL_X = (GAME_WIDTH - BALL_RADIUS) >> 1;
	public static final int BALL_INITIAL_Y = (GAME_HEIGHT - BALL_RADIUS) >> 1;
	public static final float BALL_INITIAL_DELAY_TIMER = 1f;
	public static final int BALL_INITIAL_MOVEMENT_SPEED = 120;
	public static final int BALL_SPEED_INCREASE_PER_PADDLE_DEFLECT = 20;
	public static final Color BALL_COLOR = Color.WHITE;

	public static final int UI_FONT_SIZE = 32;
	public static final int PLAYER_ONE_SCORE_X = HALF_OF_GAME_WIDTH - 48;
	public static final int PLAYER_TWO_SCORE_X = HALF_OF_GAME_WIDTH + 48;
	public static final int SCORE_TEXT_Y = 48;
	public static final Color SCORE_TEXT_COLOR = Color.WHITE;
	public static final String PLAYER_WON_TEXT_STRING = "PLAYER %d WON!";
	public static final Color PLAYER_WON_TEXT_COLOR = Color.ORANGE;
}