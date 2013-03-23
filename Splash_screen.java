package com.mehdie19.lig;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/***************************************************************************
 * this activity is used for splash screen
 * splash screen is an activity that will lunch when our program is start
 * actually we use a grafically_beautifult xml for better view of our program
 ***************************************************************************/
public class Splash_screen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
