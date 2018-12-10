package com.dwp.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.zxing.BarcodeFormat;

import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn_logout, btn_masuk, btn_keluar, btn_history;
    TextView txt_id, txt_saldo, txt_username;
    String id,saldo, username;
    private Session session;

    public static final String TAG_ID = "id";
    public static final String TAG_SALDO = "saldo";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_saldo = (TextView) findViewById(R.id.txt_saldo);  //UNTUK MENAMPILKAN SALDO USER
        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_masuk = (Button) findViewById(R.id.btn_masuk);
        btn_keluar = (Button) findViewById(R.id.btn_keluar);
        btn_history = (Button) findViewById(R.id.btn_history);

        session = new Session(this);

        id = session.getsaveTagID();
        saldo = session.getsaveSaldo();
        username = session.getsaveUsername();

        txt_id.setText("ID :  " + id);
        txt_saldo.setText("Saldo : Rp " + saldo); //UNTUK MENAMPILKAN SALDO USER
        txt_username.setText("Wellcome : " + username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                session.setLoggedIn(false);
                session.saveTagID(null);
                session.saveSaldo(null);
                session.saveUsername(null);

                Intent intent = new Intent(MainActivity.this, Login.class);
                finish();
                startActivity(intent);
            }
        });

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MasukActivity.class);
                finish();
                startActivity(intent);
            }
        });

        btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KeluarActivity.class);
                finish();
                startActivity(intent);

            }
        });

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                finish();
                startActivity(intent);

            }
        });



//    public String getTime() {
//
//        Calendar calander = Calendar.getInstance();
//        int cHour = calander.get(Calendar.HOUR);
//        int cMinute = calander.get(Calendar.MINUTE);
//        int cSecond = calander.get(Calendar.SECOND);
//        int cmilliSecond = calander.get(Calendar.MILLISECOND);
//
//        String timeResult = cHour + " : " + cMinute + " : " + cSecond + "." + cmilliSecond;
//
//        return timeResult;
    }

}
