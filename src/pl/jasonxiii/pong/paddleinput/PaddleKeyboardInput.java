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
	public void update()
	{
		if(canUpdateInput())
		{
			controlInput(enabled);
		}
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

	private boolean canUpdateInput()
	{
		return keyEvent != null && (triggeredMovingUp(enabled) || triggeredMovingDown(enabled));
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