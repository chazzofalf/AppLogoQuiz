package com.webuildsystem.EventLib.Timer;

public interface TimerEventListener 
{
	public void onTimerElapsed();
	public void onTimerInterruptedException(TimerInterruptedException timerInterruptedException);
}
