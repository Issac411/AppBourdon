package com.example.issac.myapplication.CONFIG;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public interface JSONAct {

    /* Matthieu
24/05/18
Retourne un tableau d'objets en JSON
Permet de convertir les JSONArray en Array tout court
 */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<JSONObject> JSONArrayToArray(JSONArray JSONArray) {
        int count = getElementInJSONArray(JSONArray);
        int i;
        String codes = "";
        JSONObject aElement = new JSONObject();
        ArrayList<JSONObject> lesElements = new ArrayList<JSONObject>();
        for(i=0;i<count;i++) {
            try {
                aElement = JSONArray.getJSONObject(i);
                int size = getElementInJSONObject(aElement);
                lesElements.add(aElement);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return lesElements;
    }


    /* Matthieu
    24/05/18
    Retourne un int
    récupère la taille d'un JSONArray
    */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getElementInJSONArray(JSONArray json) {
        return json.length();
    }


    /* Matthieu
    24/05/18
    Retourne un int
    récupère la taille d'un JSONAObject
    */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getElementInJSONObject(JSONObject json) {
        return json.length();
    }













}
