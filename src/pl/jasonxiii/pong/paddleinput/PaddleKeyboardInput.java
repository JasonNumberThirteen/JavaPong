package pl.jasonxiii.pong.paddleinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaddleKeyboardInput extends PaddleInput implements KeyListener
{
	private final int upMovementCode;
	private final int downMovementCode;

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
		return keyEvent != null && keyEvent.getKeyCode() == upMovementCode && enabled;
	}

	@Override
	public boolean isMovingDown()
	{
		return keyEvent != null && keyEvent.getKeyCode() == downMovementCode && enabled;
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		setKeyEvent(ke);
		setEnabled(true);
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
		setKeyEvent(ke);
		setEnabled(false);
	}

	private void setKeyEvent(KeyEvent ke)
	{
		keyEvent = ke;
	}

	private void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
}