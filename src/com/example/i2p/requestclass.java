package com.example.i2p;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class requestclass extends Activity {

	
	Button addmore;
	Button EnoughAndSave;
	
	String fname;
	Document document = new Document();
	
	private static final int CAM_REQUEST = 1313;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.requestactiityss);
		addmore = (Button) findViewById(R.id.add);
		EnoughAndSave = (Button) findViewById(R.id.enough);

		Bundle extras = getIntent().getExtras();
		if (extras != null){
			fname = extras.getString("fnames");	
		}
		
		
		
		
     //-------------
	
		//-------------------PDF portion-----------------
		 String fpath = "/sdcard/"+fname+".pdf";
         File file = new File(fpath);
         // If file does not exists, then create it
         if (!file.exists()) {
             try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         try {
			PdfWriter.getInstance(document,  new FileOutputStream(file.getAbsoluteFile()));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         document.open();
	    
	
		
	  addmore.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, CAM_REQUEST);
			
			
			
		}
	   
	   });
	  
	  
	  EnoughAndSave.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
	
			document.close();
			finish();
		}
	});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		 if(requestCode == CAM_REQUEST) {
				
				Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				thumbnail.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
				try {
					Image image = Image.getInstance(stream.toByteArray());
					document.add(image);
				} catch (IOException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	
}
