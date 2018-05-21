package com.example.issac.ppe2sanskt.CONFIG;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpClient extends AsyncTask<String, Void, String>{
    protected String result = "";


    /*
    07/05
    Boutte
    Classe de Boutte pour sa récupération de données en JSON, il utilise donc une fonction qui s'exécute en arrière plan pour choper les données;
    Elle est utilisée dans getJsonFromUrl
     */
    protected String doInBackground(String... urls) {
        if(urls.length == 1) {
            String link;
            link = urls[0];
            try {
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                this.result = content.toString();
            } catch (Throwable e) {
                this.result = e.toString();
            }
        }else{
            this.result = "error";
        }
        return (this.result);
    }














    protected void onPostExecute(Boolean result) {
    }
    public String getResult(){
        return(this.result);
    }
}
