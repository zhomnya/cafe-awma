package com.awma.cafeManager;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;


public class HelloTabWidget extends TabActivity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabview);
        
        Resources res = getResources(); // Resource object to get Drawables
        final TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, MakananActivity.class);
        // Initialize a TabSpec for each tab and add it to the TabHost
        tabHost.addTab(tabHost.newTabSpec("makanan").setIndicator("Makanan",res.getDrawable(R.drawable.ic_tab_makanan)).setContent(intent));
        
        getTabWidget().getChildAt(0).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				//Toast.makeText(HelloTabWidget.this, "" + tabHost.getChildCount(), Toast.LENGTH_SHORT).show();
				tabHost.setCurrentTab(0);
			}
		});
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, MinumanActivity.class);
        tabHost.addTab(tabHost.newTabSpec("minuman").setIndicator("Minuman",res.getDrawable(R.drawable.ic_tab_minuman)).setContent(intent));
        getTabWidget().getChildAt(1).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Toast.makeText(HelloTabWidget.this, "" + tabHost.getTabWidget().getChildCount(), Toast.LENGTH_SHORT).show();
				tabHost.setCurrentTab(1);
			}
		});
        
        tabHost.setCurrentTab(1);
    }
}