package com.pgyt.eveapitool;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.pgyt.eveapitool.CommonConstants.BLANK_STRING;
import static com.pgyt.eveapitool.CommonConstants.CHARSET_UTF8;
import static com.pgyt.eveapitool.CommonConstants.REQUEST_METHOD_POST;

/**
 * Created by pgyt on 2018/03/24.
 */

public class HttpResponseAsync extends AsyncTask<Void, Void, String> {

    private Listener listener;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // 前処理
    }

    @Override
    protected String doInBackground(Void... voids) {

        HttpURLConnection httpUrlConnection;
        URL url;
        String urlString = "https://api.eveonline.com/account/APIKeyInfo.xml.aspx?&keyID=0000000&vCode=xxxxxxxxxx";

        try {
            url = new URL(urlString);

            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod(REQUEST_METHOD_POST);
            httpUrlConnection.setInstanceFollowRedirects(false);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.connect();

            String readString;
            InputStream in = httpUrlConnection.getInputStream();
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, CHARSET_UTF8));

            while((readString = br.readLine()) != null)
            {
                sb.append(readString);
            }
            return sb.toString();

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
        listener.onSucces(result);
    }

    void setListener(Listener listener){
        this.listener = listener;
    }

    interface Listener{
        void onSucces(String result);
    }
}
