package com.webuildsystems.AppLogoQuiz.data;

import android.content.pm.ActivityInfo;

public class RawInfos 
{
	private ActivityInfo[] infos;
	public ActivityInfo[] getRawInfos()
	{
		return infos;
	}
	public RawInfos(ActivityInfo[] infos)
	{
		this.infos = infos;
	}
}
