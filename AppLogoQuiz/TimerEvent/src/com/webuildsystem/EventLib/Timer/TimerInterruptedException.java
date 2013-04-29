package com.webuildsystem.EventLib.Timer;

public class TimerInterruptedException extends Exception 
{
	public TimerInterruptedException(Throwable cause)
	{
		super(cause);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The timer was interrupted." + "\n" + super.getMessage();
	}
}