package pl.jasonxiii.pong.paddleinput;

import java.awt.event.KeyEvent;

public class PaddleKeyboardInput extends PaddleInput
{
	private final int upMovementCode;
	private final int downMovementCode;

	private KeyEvent keyEvent;

	public PaddleKeyboardInput(int upMovementCode, int downMovementCode)
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