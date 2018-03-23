package com.pgyt.eveapitool;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuich on 2018/03/24.
 */

public class HttpResponseAsync extends AsyncTask<Void, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // 前処理
    }

    @Override
    protected String doInBackground(Void... voids) {

        HttpURLConnection httpUrlConnection;
        URL url;
        String urlString = "http://xxxxxxxxxxxxx";

        try {
            url = new URL(urlString);

            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setInstanceFollowRedirects(false);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.connect();


            InputStream in = httpUrlConnection.getInputStream();
            byte bodyByte[] = new byte[1024];
            in.read(bodyByte);
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
            
        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        // 後処理
    }
}
