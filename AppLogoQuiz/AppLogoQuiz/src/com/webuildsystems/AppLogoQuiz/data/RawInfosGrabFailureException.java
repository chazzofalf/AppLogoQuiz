package com.webuildsystems.AppLogoQuiz.data;

public class RawInfosGrabFailureException extends Exception 
{
	public RawInfosGrabFailureException(Throwable cause)
	{
		super(cause);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Failed to grab raw application information";
	}
}
