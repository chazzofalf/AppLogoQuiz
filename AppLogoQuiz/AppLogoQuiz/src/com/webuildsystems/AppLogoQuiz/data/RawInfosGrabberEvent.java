package com.webuildsystems.AppLogoQuiz.data;

import com.webuildsystems.EventLib.Event;
import com.webuildsystems.EventLib.EventRunnable;

public class RawInfosGrabberEvent extends Event<RawInfosGrabberEventListener>
{
	public void fireOnRawInfosObtained(RawInfos rawInfos)
	{
		final RawInfos _rawInfos = rawInfos;
		fireEvent(new EventRunnable<RawInfosGrabberEventListener>() {
			
			@Override
			public void run(RawInfosGrabberEventListener eventListener) {
				// TODO Auto-generated method stub
				eventListener.onRawInfosObtained(_rawInfos);
			}
		});
	}
	public void fireOnRawInfosFailureToGrab(RawInfosGrabFailureException rawInfosFailedToGrab)
	{
		final RawInfosGrabFailureException _rawInfosFailedToGrab = rawInfosFailedToGrab;
		fireEvent(new EventRunnable<RawInfosGrabberEventListener>() {
			
			@Override
			public void run(RawInfosGrabberEventListener eventListener) {
				// TODO Auto-generated method stub
				eventListener.onRawInfosFailureToGrab(_rawInfosFailedToGrab);
			}
		});
	}
}
