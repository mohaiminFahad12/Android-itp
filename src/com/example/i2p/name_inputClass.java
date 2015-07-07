package com.example.i2p;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class name_inputClass extends Activity {
	
	Button btn;
    EditText edttext;
    String ets;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		btn=(Button) findViewById(R.id.clickit);
		edttext = (EditText) findViewById(R.id.nameofpdf);

	    
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	            
						Intent it = new Intent(name_inputClass.this, requestclass.class);
						String st = edttext.getText().toString();
						it.putExtra("fnames",st);
						startActivity(it);
			}
		});

		
		
	}

}
