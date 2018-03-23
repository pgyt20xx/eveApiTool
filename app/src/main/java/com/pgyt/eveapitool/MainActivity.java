package com.pgyt.eveapitool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    private HttpResponseAsync task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = new HttpResponseAsync();
        task.execute();

    }
}
