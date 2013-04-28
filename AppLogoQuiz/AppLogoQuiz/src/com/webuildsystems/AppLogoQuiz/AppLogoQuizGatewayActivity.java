package com.webuildsystems.AppLogoQuiz;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class AppLogoQuizGatewayActivity extends Activity
{
	private Dialog aboutDialog;
	private Dialog scoresDialog;
	private Dialog playDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(LayoutInflater.from(this).inflate(R.layout.app_logo_quiz_gateway, null));
	}
	public void onGatewayAboutButtonClicked(View view)
	{
		Dialog dialog = new Dialog(this);
		dialog.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface dialog) {
				// TODO Auto-generated method stub
				aboutDialog = null;
			}
		});
		dialog.setContentView(LayoutInflater.from(this).inflate(R.layout.app_logo_quiz_about, null));
		dialog.setTitle(getResources().getString(R.string.about_app_btn_text));
		aboutDialog = dialog;
		dialog.show();
	}
	public void onGatewayScoresButtonClicked(View view)
	{
		
	}
	public void onGatewayPlayButtonClicked(View view)
	{
		
	}
	public void onAboutDialogOkClicked(View view)
	{
		aboutDialog.dismiss();
	}
	public void onAboutDialogEmailClicked(View view)
	{
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("text/plain");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {getResources().getString(R.string.contact_email)});
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
		emailIntent.putExtra(Intent.EXTRA_TEXT, "");
		startActivity(emailIntent);
	}
}
