package com.pgyt.eveapitool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private HttpResponseAsync task;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = new HttpResponseAsync();
        task.setListener(createHttpResponseAsyncListener());
        task.execute();

    }

    private HttpResponseAsync.Listener createHttpResponseAsyncListener(){
        return new HttpResponseAsync.Listener() {
            @Override
            public void onSucces(String result) {
                textView = findViewById(R.id.text_view);
                textView.setText(result);
            }
        };
    }
}
