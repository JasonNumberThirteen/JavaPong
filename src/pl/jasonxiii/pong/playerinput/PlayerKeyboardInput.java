package pl.jasonxiii.pong.playerinput;

import java.awt.event.KeyEvent;

public class PlayerKeyboardInput extends PlayerInput
{
	private final int upMovementCode;
	private final int downMovementCode;

	private KeyEvent keyEvent;

	public PlayerKeyboardInput(int upMovementCode, int downMovementCode)
	{
		this.upMovementCode = upMovementCode;
		this.downMovementCode = downMovementCode;
	}

	public void setKeyEvent(KeyEvent ke)
	{
		keyEvent = ke;
	}

	@Override
	public boolean triggeredMovingUp(boolean enable)
	{
		return keyEvent.getKeyCode() == upMovementCode && isMovingUp() != enable;
	}

	@Override
	public boolean triggeredMovingDown(boolean enable)
	{
		return keyEvent.getKeyCode() == downMovementCode && isMovingDown() != enable;
	}
}