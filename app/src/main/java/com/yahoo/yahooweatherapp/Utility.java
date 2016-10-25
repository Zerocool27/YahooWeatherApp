package com.yahoo.yahooweatherapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fatihaktepe on 10/25/16.
 */

public class Utility {
    public static JSONObject getJSONObject(String urlString) {
        HttpURLConnection urlConnection = null;
        BufferedReader br = null;
        try {
            URL url = new URL(urlString);


            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream stream = urlConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(stream));
            StringBuffer jsonString = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                jsonString.append(line + "\n");
            }
            br.close();
            JSONObject resultObj = new JSONObject(jsonString.toString());

            return resultObj;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
