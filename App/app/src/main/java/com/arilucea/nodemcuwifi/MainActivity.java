package com.arilucea.nodemcuwifi;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText SSID;
    EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SSID = (EditText) findViewById(R.id.SSID);
        Pass = (EditText) findViewById(R.id.PASS);

        Button ButtonSend = (Button) findViewById(R.id.ButtonSend);

        ButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = call((SSID.getText()).toString(), (Pass.getText()).toString());

                Log.d("aaaaaaaaaaaaaa", a);
            }
        });

    }


    public String call(String SSID, String Pass){
        String json = "";
        String sql = "---";

        URL url = null;
        HttpURLConnection conn;


        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();
            Log.d("aaaaaaaaaaaaaaaaaaa", json);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (json);
    }
}
