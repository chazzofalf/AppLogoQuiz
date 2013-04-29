package com.webuildsystem.EventLib.Timer;

import com.webuildsystems.EventLib.Event;
import com.webuildsystems.EventLib.EventRunnable;

public class TimerEvent extends Event<TimerEventListener>
{
	public void fireOnTimerElapsed()
	{
		fireEvent(new EventRunnable<TimerEventListener>() {
			
			@Override
			public void run(TimerEventListener eventListener) {
				// TODO Auto-generated method stub
				eventListener.onTimerElapsed();
			}
		});
	}
	public void fireOnTimerInterrupted(TimerInterruptedException timerInterruptedException)
	{
		final TimerInterruptedException _timerInterruptedException = timerInterruptedException;
		fireEvent(new EventRunnable<TimerEventListener>() {
			@Override
			public void run(TimerEventListener eventListener) {
				// TODO Auto-generated method stub
				eventListener.onTimerInterruptedException(_timerInterruptedException);
			}
		});
	}
}
