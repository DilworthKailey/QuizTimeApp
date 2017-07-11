package com.midnight_arts.android.quiztimeapp;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kailey on 6/29/2017.
 */

public class Weather extends AsyncTask<String,Void,String> {

    public static String temper;
    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myconnection = null;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection)link.openConnection();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while(data!= -1){
                char current = (char)data;
                result+= current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            double tempInt = Double.parseDouble(main.getString("temp"));
            String tempIn = Double.toString(Math.round((tempInt * 1.8 - 459.67 ) * 10) / 10);
            String placeName = myObject.getString("name");

            temper = tempIn;

            MainActivity.place.setText(placeName);
            MainActivity.temp.setText(tempIn + "F");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
