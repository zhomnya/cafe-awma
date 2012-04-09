package com.awma.cafeManager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private Activity activity;
    
    
    public ItemAdapter(Context c, Activity a) {
        mContext = c;
        activity = a;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	View MyView = convertView;
        
        //ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	
        	LayoutInflater li = activity.getLayoutInflater();
            MyView = li.inflate(R.layout.item_view, null);
        	
        	// Add The Text!!!
            TextView tv = (TextView)MyView.findViewById(R.id.grid_item_text);
            tv.setText(name[position]);
            
            TextView tp = (TextView)MyView.findViewById(R.id.grid_item_price);
            tp.setText(price[position]);
            // Add The Image!!!           
            ImageView iv = (ImageView)MyView.findViewById(R.id.grid_item_image);
            //iv.setLayoutParams();
            iv.setPadding(8, 8, 8, 8);
            
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setImageResource(mThumbIds[position]);
            
        	
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
        } else {
            //imageView = (ImageView) convertView;
        }

        //imageView.setImageResource();
        return MyView;
    }

    // references to our images
    private Integer[] mThumbIds = {
    };
    
    private String[] name = {
    		
    };
    
    private String[] price = {
    		
    };
    
    public void setImageRef(Integer[] imageRef){
    	mThumbIds = imageRef;
    }
    
    public void setName(String [] nameArray){
    	name = nameArray;
    }
    public void setPrice(String[] priceArray){
    	price = priceArray;
    }
}