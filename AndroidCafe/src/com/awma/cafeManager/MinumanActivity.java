package com.awma.cafeManager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MinumanActivity extends Activity {
	private ArrayList<Item>itemList = new ArrayList<Item>();
	private PopupWindow pop; 
	Pesanan pesanan;
	Bundle bundle;
	
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
		itemList.add(new Item(0, "item 1", "10000", R.drawable.sample_11));
		itemList.add(new Item(1, "item 2", "20000", R.drawable.sample_12));
		itemList.add(new Item(2, "item 3", "30000", R.drawable.sample_13));
		itemList.add(new Item(3, "item 4", "40000", R.drawable.sample_14));
		itemList.add(new Item(4, "item 5", "10000", R.drawable.sample_11));
		itemList.add(new Item(5, "item 6", "20000", R.drawable.sample_12));
		itemList.add(new Item(6, "item 7", "30000", R.drawable.sample_13));
		itemList.add(new Item(7, "item 8", "40000", R.drawable.sample_14));
	}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_minuman);
        
        bundle = this.getIntent().getExtras();
        pesanan = new Pesanan(bundle.getString("nomorMeja"),bundle.getBoolean("lanjut"));
        
        initComponentItem();
        ItemAdapter imageAdapt = new ItemAdapter(this,this);
        imageAdapt.setImageRef(setImageRef(itemList));
        imageAdapt.setName(setNameRef(itemList));
        imageAdapt.setPrice(setPriceRef(itemList));
        GridView gridview2 = (GridView) findViewById(R.id.gridview2);
        gridview2.setAdapter(imageAdapt);
        
        gridview2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	
            	final int ids = position;
            	
            	LayoutInflater inflater = (LayoutInflater) MinumanActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        		//Inflate the view from a predefined XML layout
        		View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popupview));
        		
        		ImageView img = (ImageView) layout.findViewById(R.id.itemImage);
        		img.setImageResource(itemList.get(position).getPict());
        		
        		TextView nama = (TextView) layout.findViewById(R.id.namaItem);
        		nama.setText(itemList.get(position).getName());
        		
        		TextView price = (TextView) layout.findViewById(R.id.itemPrice);
        		price.setText(itemList.get(position).getPrice());
        		
        		final EditText jumlah = (EditText) layout.findViewById(R.id.jumlah);
        		
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
						pop.dismiss();
						P.pesanan.add(new ItemPesanan(ids, jumlah.getText().toString(),1));
						Toast.makeText(MinumanActivity.this, "Anda Memesan " + itemList.get(ids).getName() + " Sebanyak " + jumlah.getText().toString() , Toast.LENGTH_LONG).show();
					}
				});
            }
        });
        
    }
}