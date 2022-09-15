package pl.jasonxiii.pong.paddleinput;

public abstract class PaddleInput
{
	private boolean isMovingUp, isMovingDown;

	public abstract void update();
	public abstract boolean triggeredMovingUp(boolean enable);
	public abstract boolean triggeredMovingDown(boolean enable);

	public final void controlInput(boolean enable)
	{
		if(triggeredMovingUp(enable))
		{
			isMovingUp = enable;
		}
		else if(triggeredMovingDown(enable))
		{
			isMovingDown = enable;
		}
	}

	public final boolean isMovingUp()
	{
		return isMovingUp;
	}

	public final boolean isMovingDown()
	{
		return isMovingDown;
	}
}