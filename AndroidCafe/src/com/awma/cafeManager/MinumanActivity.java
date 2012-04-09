package com.awma.cafeManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MinumanActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.grid_minuman);

        Integer[] imageRef1 = {R.drawable.sample_11,R.drawable.sample_12,R.drawable.sample_13,R.drawable.sample_14,R.drawable.sample_11,R.drawable.sample_12,R.drawable.sample_13,R.drawable.sample_14};
        ItemAdapter imageAdapt = new ItemAdapter(this,this);
        imageAdapt.setImageRef(imageRef1);
        GridView gridview2 = (GridView) findViewById(R.id.gridview2);
        gridview2.setAdapter(imageAdapt);
        
        gridview2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MinumanActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}