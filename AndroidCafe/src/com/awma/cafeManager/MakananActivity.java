package com.awma.cafeManager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MakananActivity extends Activity {
	private PopupWindow pop; 
	Pesanan pesanan;
	Bundle bundle;
	
	private ArrayList<Item>itemList = new ArrayList<Item>();
	public Integer[] setImageRef(ArrayList<Item> item){
		Integer[] img = new Integer[item.size()];
		
		for(int i = 0;i<item.size();i++){
			img[i] = item.get(i).getPict();
		}
		
		return img;
    } 
	
	public String[] setPriceRef(ArrayList<Item> item){
		String[] pric = new String[item.size()];
		
		for(int i = 0;i<item.size();i++){
			pric[i] = item.get(i).getPrice();
		}
		
		return pric;
    }
	
	public String[] setNameRef(ArrayList<Item> item){
		String[] pric = new String[item.size()];
		
		for(int i = 0;i<item.size();i++){
			pric[i] = item.get(i).getName();
		}
		
		return pric;
    }
	
	public void initComponentItem(){
		itemList.add(new Item(0, "item 1", "10000", R.drawable.sample_01));
		itemList.add(new Item(1, "item 2", "20000", R.drawable.sample_02));
		itemList.add(new Item(2, "item 3", "30000", R.drawable.sample_03));
		itemList.add(new Item(3, "item 4", "40000", R.drawable.sample_04));
		itemList.add(new Item(4, "item 5", "10000", R.drawable.sample_01));
		itemList.add(new Item(5, "item 6", "20000", R.drawable.sample_02));
		itemList.add(new Item(6, "item 7", "30000", R.drawable.sample_03));
		itemList.add(new Item(7, "item 8", "40000", R.drawable.sample_04));
	}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grid_makanan);
        bundle = this.getIntent().getExtras();
        pesanan = new Pesanan(bundle.getString("nomorMeja"),bundle.getBoolean("lanjut"));
        
        //Integer[] imageRef = {R.drawable.sample_01,R.drawable.sample_02,R.drawable.sample_03,R.drawable.sample_04,R.drawable.sample_01,R.drawable.sample_02,R.drawable.sample_03,R.drawable.sample_04};
        initComponentItem();
        ItemAdapter imageAdapt1 = new ItemAdapter(this,this);
        imageAdapt1.setImageRef(setImageRef(itemList));
        imageAdapt1.setName(setNameRef(itemList));
        imageAdapt1.setPrice(setPriceRef(itemList));
        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(imageAdapt1);
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	LayoutInflater inflater = (LayoutInflater) MakananActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        		//Inflate the view from a predefined XML layout
        		View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popupview));
        		
        		ImageView img = (ImageView) layout.findViewById(R.id.itemImage);
        		img.setImageResource(itemList.get(position).getPict());
        		
        		TextView nama = (TextView) layout.findViewById(R.id.namaItem);
        		nama.setText(itemList.get(position).getName());
        		
        		TextView price = (TextView) layout.findViewById(R.id.itemPrice);
        		price.setText(itemList.get(position).getPrice());
        		
        		EditText jumlah = (EditText) layout.findViewById(R.id.jumlah);
        		
        		pop = new PopupWindow(layout,400,500,true); 
        		pop.setBackgroundDrawable(new BitmapDrawable());
        		// display the popup in the center
        		pop.showAtLocation(layout, Gravity.CENTER, 0, 0);
        		Button butCancel = (Button)layout.findViewById(R.id.batalBtn);
        		Button butOK = (Button)layout.findViewById(R.id.pesanBtn);
        		
        		butCancel.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pop.dismiss();
					}
				});
        		butOK.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
            }
        });
    }
}