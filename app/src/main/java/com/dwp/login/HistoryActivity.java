package com.dwp.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.function.ToLongBiFunction;
import com.dwp.login.m_JSON.JSONDownloader;


public class HistoryActivity extends AppCompatActivity {
    
    
    String jsonURL="http://192.168.1.102/coba_login/history.php";

    ListView listView;
    Button  btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button btn_back = (Button) findViewById(R.id.btn_back);


//        @SuppressLint("NewApi") Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.lv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(HistoryActivity.this,jsonURL, listView).execute();
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
                finish();
                startActivity(intent);


            }

            private void setSupportActionBar(Toolbar toolbar) {
            }
        });
    }
}

