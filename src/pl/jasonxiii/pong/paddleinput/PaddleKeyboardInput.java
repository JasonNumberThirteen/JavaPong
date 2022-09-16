package pl.jasonxiii.pong.paddleinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaddleKeyboardInput extends PaddleInput implements KeyListener
{
	private final int upMovementCode, downMovementCode;

	private KeyEvent keyEvent;
	private boolean enabled;

	public PaddleKeyboardInput(int upMovementCode, int downMovementCode)
	{
		this.upMovementCode = upMovementCode;
		this.downMovementCode = downMovementCode;
	}

	@Override
	public boolean isMovingUp()
	{
		return keyEventIsAssigned() && keyCode() == upMovementCode && enabled;
	}

	@Override
	public boolean isMovingDown()
	{
		return keyEventIsAssigned() && keyCode() == downMovementCode && enabled;
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		setState(ke, true);
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		setState(ke, false);
	}

	private void setState(KeyEvent ke, boolean enabled)
	{
		setKeyEvent(ke);
		setEnabled(enabled);
	}

	private void setKeyEvent(KeyEvent ke)
	{
		keyEvent = ke;
	}

	private void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	private int keyCode()
	{
		return keyEventIsAssigned() ? keyEvent.getKeyCode() : 0;
	}

	private boolean keyEventIsAssigned()
	{
		return keyEvent != null;
	}
}