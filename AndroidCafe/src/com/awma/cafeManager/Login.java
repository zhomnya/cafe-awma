package com.awma.cafeManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{
	public String pass;
	public boolean lanjut = false;
	Bundle bundle = new Bundle();
	public static final String password = "awma";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText pass = (EditText) findViewById(R.id.pass);
        final EditText no_meja = (EditText) findViewById(R.id.nomeja);
        final CheckBox cb = (CheckBox) findViewById(R.id.lanjutkan);
        Button lanjutBnt = (Button) findViewById(R.id.buttonMasuk);
        
        cb.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				if(lanjut == false){
					lanjut = true;
				} else {
					lanjut = false;
				}
			}
		});
        
        lanjutBnt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String pwd = pass.getText().toString();
				if(password.equals(pwd)){
					bundle.putBoolean("lanjut", lanjut);
					bundle.putString("nomorMeja", no_meja.getText().toString());
					
					P.newP(no_meja.getText().toString(), lanjut);
					
					//Toast.makeText(Login.this, "" + lanjut + "-" + pass.getText() + "-" + no_meja.getText(), Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(v.getContext(), HelloTabWidget.class).putExtras(bundle);
					startActivityForResult(intent, 0);
				}
			}
		});
	}
}
