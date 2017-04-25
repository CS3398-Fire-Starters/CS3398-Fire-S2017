package com.example.derek.workouttracker20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


public class JSONParser {

    static InputStream is=null;
    static JSONObject jsonObj;
    static String json = "";
    //default constr.
    public JSONParser(){

    }

    public JSONObject getJSONFromUrl(final String url)
    {
        //make HTTP Request
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            //Execute POST request/storing from server to local.
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder str = new StringBuilder();
            String strLine = null;
            //Building while string !equal null.
            while ((strLine = reader.readLine()) != null){
                str.append(strLine + "\n");
            }

            //Close input stream.
            is.close();
            //Convert builder to string.
            json = str.toString();
        }
        catch (Exception e){
            Log.e("Error", "something went wrong with converting result" + e.toString());
        }
        //Parsing string to JSON
        try{
            jsonObj = new JSONObject(json);
        }catch (JSONException e){
            Log.e("json parsing", "" + e.toString());
        }
        return jsonObj;
    }

    public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params)
    {
        //Make Request
        try{
            if (method == "POST"){
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }
            else if (method == "GET")
            {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"),8);
            StringBuilder str = new StringBuilder();
            String strLine = null;
            while ((strLine = reader.readLine()) != null){
                str.append(strLine + "\n");
            }
            is.close();
            json = str.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        //parse into json.
        try{
            jsonObj = new JSONObject(json);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObj;
    }
}