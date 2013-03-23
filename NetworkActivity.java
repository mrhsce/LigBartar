package com.mehdie19.lig;

/************************************************
 * I add all data that we need to my_data
 * that is object of data.java
 * and you must use my_data to complete program
 ************************************************/

import java.util.ArrayList;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class NetworkActivity extends Activity {
	private ProgressDialog progressBar;//for animation
	private int temp=0;//for a bug
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if ( isConnectedToInternet() )
     		new DownloadXmlTask().execute();
     	else
     		{Toast.makeText(this, "Interconnection not found.", 1).show();
     		temp=1;
     		}

	}	  

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (temp==0)
			stopLoading();
	}

    /*********************************************************
     * this class is a useful class that prevent from crashing
     *  when download of data take very long time
     *********************************************************/

    private class DownloadXmlTask extends AsyncTask<Void, Void, String> {
		@Override
	    protected void onPreExecute() {//is automatic run
			showLoading();
	    }
		
		@Override
        protected String doInBackground(Void... esult) {//msg is sent for argument result 
                String msg= ParserFunctions.getXML();
                return msg;
        }

        @Override
        protected void onPostExecute(String result) { 
        	    if (result.length()>100)
        	    {//when not internet show the massage that len of it is smaller than 100
        	    	data my_data=ParserFunctions.Parse(result);
        	    	//all of data that we need is in all_data and we must use it for program
        	    	checkLog(my_data);
        	    }
    			stopLoading();	    
    	    }    
        }

  	/* ----------------------------------------------------------------------------------
	 * This method just shows the result of data which is parsed and show it in Logcat.
	 * only for check that my data are correct
	 * ----------------------------------------------------------------------------------*/
	@SuppressWarnings("static-access")
	private void checkLog(data itemList) {
		ArrayList<String> TeamName       = itemList.getTeamName();
	    ArrayList<String> GameNo 		 = itemList.getGameNo();
	    ArrayList<String> PlayEqual      = itemList.getPlayEqual();
	    ArrayList<String> PlayFaild      = itemList.getPlayFaild();
	    ArrayList<String> PlayWin    	 = itemList.getPlayWin();
	    ArrayList<String> Emtiaz  	 	 = itemList.getEmtiaz();
	    for(String str: TeamName)
	    	Log.i("TeamName", str);
	    for(String str: GameNo)
	    	Log.i("GameNo", str);
	    for(String str: PlayEqual)
	    	Log.i("PlayEqual", str);
	    for(String str: PlayFaild)
	    	Log.i("PlayFaild", str);
	    for(String str: PlayWin)
	    	Log.i("PlayWin", str);
	    for(String str: Emtiaz)
	    	Log.i("Emtiaz", str);
	    
	    Log.d("TeamName",String.valueOf(TeamName.size()));
	    Log.d("Emtiaz",String.valueOf(Emtiaz.size()));
	    Log.d("PlayWin",String.valueOf(PlayWin.size()));
	    Log.d("PlayFaild",String.valueOf(PlayFaild.size()));
	    Log.d("PlayEqual",String.valueOf(PlayEqual.size()));
	    Log.d("GameNo",String.valueOf(GameNo.size()));
	}
	/*-----------------------------------------------------------------------------------
	 *  Checking Internet connection. True: connection found, False: connection not found 
	 *  ---------------------------------------------------------------------------------*/
	public boolean isConnectedToInternet(){
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
	
	/*-----------------------------------------------------------------------------------
	 *  Showing / Stopping progress dialog which is showing loading animation
	 *  ---------------------------------------------------------------------------------*/
	private void showLoading(){
		progressBar = ProgressDialog.show(NetworkActivity.this, "", "");
		progressBar.setContentView(R.layout.loading);
		progressBar.setCancelable(true);
		final ImageView imageView = (ImageView) progressBar.findViewById(R.id.blankImageView); 
		Animation rotation = AnimationUtils.loadAnimation(NetworkActivity.this, R.anim.rotate);
		imageView.startAnimation(rotation); 
		Log.d("end fun loading","h");
	}
	
	
	private void stopLoading() {		
		if(progressBar.isShowing())
			progressBar.dismiss();
	}
	
}