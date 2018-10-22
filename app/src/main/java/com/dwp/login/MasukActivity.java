package com.dwp.login;

import android.Manifest;

import android.content.Context;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.zxing.BarcodeFormat;

import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Calendar;
import java.util.Date;


public class MasukActivity extends AppCompatActivity {
    ConnectivityManager conMgr;

    EditText text;
    Button gen_btn;
    ImageView image;
    String text2Qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        text = (EditText) findViewById(R.id.text);
        gen_btn = (Button) findViewById(R.id.gen_btn);
        image = (ImageView) findViewById(R.id.image);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }


        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Date today = new Date();
//
//                String dateStr = "04/05/2010";
//
//                SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
//                Date dateObj = curFormater.parse(dateStr);
//                SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");
//
//                String newDateStr = postFormater.format(dateObj);

                //Convert to calendar Object
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(today);





//                int cHour = calendar.get(Calendar.HOUR);
//                int cMinute = calendar.get(Calendar.MINUTE);
//                int cSecond = calendar.get(Calendar.SECOND);
//                int cmilliSecond = calendar.get(Calendar.MILLISECOND);
////
//                String Time = cHour + " : " + cMinute + " : " + cSecond + "." + cmilliSecond;
////                String Time =

                text2Qr = text.getText().toString().trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode("text2Qr", BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix );
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });

    }
}
