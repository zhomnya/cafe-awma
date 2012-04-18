package com.awma.cafeManager;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class HelloTabWidget extends TabActivity{
    /** Called when the activity is first created. */
	public String s;
	Bundle bundle = new Bundle();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabview);
        
        Resources res = getResources(); // Resource object to get Drawables
        final TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        
        bundle.putBoolean("lanjut", this.getIntent().getExtras().getBoolean("lanjut"));
		bundle.putString("nomorMeja", this.getIntent().getExtras().getString("nomorMeja"));
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, MakananActivity.class).putExtras(bundle);
        // Initialize a TabSpec for each tab and add it to the TabHost
        tabHost.addTab(tabHost.newTabSpec("makanan").setIndicator("Makanan",res.getDrawable(R.drawable.ic_tab_makanan)).setContent(intent));
        getTabWidget().getChildAt(0).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Toast.makeText(HelloTabWidget.this, "" + tabHost.getChildCount(), Toast.LENGTH_SHORT).show();
				tabHost.setCurrentTab(0);
			}
		});
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, MinumanActivity.class).putExtras(bundle);
        tabHost.addTab(tabHost.newTabSpec("minuman").setIndicator("Minuman",res.getDrawable(R.drawable.ic_tab_minuman)).setContent(intent));
        getTabWidget().getChildAt(1).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Toast.makeText(HelloTabWidget.this, "" + tabHost.getTabWidget().getChildCount(), Toast.LENGTH_SHORT).show();
				tabHost.setCurrentTab(1);
			}
		});
        
        
        tabHost.setCurrentTab(1);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:{
            	Toast.makeText(this, "You pressed the logout!", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.daftar:{
//            	bundle.putStringArrayList("jumlah", pesanan.getJumlah());
//            	bundle.putIntegerArrayList("id", pesanan.getId());
            	
//            	Toast.makeText(HelloTabWidget.this, "size " + P.pesanan.size(), Toast.LENGTH_SHORT).show();
            	Intent intent = new Intent(HelloTabWidget.this, DaftarPesanan.class);
				startActivityForResult(intent, 0);
            }
            break;
        }
        return true;
    }
    
}