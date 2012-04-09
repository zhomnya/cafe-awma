package com.awma.cafeManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MakananActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grid_makanan);
        
        Integer[] imageRef = {R.drawable.sample_01,R.drawable.sample_02,R.drawable.sample_03,R.drawable.sample_04,R.drawable.sample_01,R.drawable.sample_02,R.drawable.sample_03,R.drawable.sample_04};
        ItemAdapter imageAdapt1 = new ItemAdapter(this,this);
        imageAdapt1.setImageRef(imageRef);
        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(imageAdapt1);
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MakananActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}