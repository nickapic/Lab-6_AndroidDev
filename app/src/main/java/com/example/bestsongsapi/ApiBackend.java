package com.example.bestsongsapi;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ApiBackend extends AsyncTask<Void,Void,Void> {
    String JsonData="";
    String OneObject="";
    String AllObjects="";


    @Override
    //Background Thread
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL("https://api.myjson.com/bins/eia16");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String currenices ="";
            while(currenices != null ){
                currenices = bufferedReader.readLine();
                JsonData =  JsonData + currenices;
            }
            JSONArray array = new JSONArray(JsonData);
            for(int i = 0;i< array.length();i++){
                JSONObject obj = (JSONObject) array.get(i);
                OneObject = "Position : " + obj.get("position")+"\n"+
                        "Song Name : "+ obj.get("song")+"\n"+
                        "Name of the Artist : " + obj.get("artist")+"\n"+"\n";

                AllObjects = AllObjects + OneObject;

            }
        }

        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    //UI THREAD
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.AllObjects);
    }
}
