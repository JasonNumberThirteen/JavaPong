package pl.jasonxiii.pong;

import java.awt.event.KeyEvent;

public class PlayerInput
{
	private final int upMovementCode;
	private final int downMovementCode;

	private boolean isMovingUp, isMovingDown;

	public PlayerInput(int upMovementCode, int downMovementCode)
	{
		this.upMovementCode = upMovementCode;
		this.downMovementCode = downMovementCode;
	}

	public void controlInput(KeyEvent ke, boolean enable)
	{
		int code = ke.getKeyCode();

		if(pressedMovingUpKey(code, enable))
		{
			isMovingUp = enable;
		}
		else if(pressedMovingDownKey(code, enable))
		{
			isMovingDown = enable;
		}
	}

	public boolean isMovingUp()
	{
		return isMovingUp;
	}

	public boolean isMovingDown()
	{
		return isMovingDown;
	}

	private boolean pressedMovingUpKey(int code, boolean enable)
	{
		return code == upMovementCode && isMovingUp != enable;
	}

	private boolean pressedMovingDownKey(int code, boolean enable)
	{
		return code == downMovementCode && isMovingDown != enable;
	}
}