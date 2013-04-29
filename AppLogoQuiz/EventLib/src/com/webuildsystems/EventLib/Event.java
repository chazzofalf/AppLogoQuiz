package com.webuildsystems.EventLib;

import java.util.ArrayList;

public class Event<Listener>
{
	private ArrayList<Listener> listeners = new ArrayList<>();
	public void addListener(Listener listener)
	{
		this.listeners.add(listener);
	}
	public void removeListener(Listener listener)
	{
		this.listeners.remove(listener);
	}
	protected void fireEvent(EventRunnable<Listener> eventAction)
	{
		final EventRunnable<Listener> _eventAction = eventAction;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				@SuppressWarnings("unchecked")
				Listener[] listeners = (Listener[])Event.this.listeners.toArray();
				for (Listener listener : listeners)
				{
					final Listener _listener = listener;
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							_eventAction.run(_listener);
						}
					}).start();
					
				}
			}
		}).start();
	}
}
