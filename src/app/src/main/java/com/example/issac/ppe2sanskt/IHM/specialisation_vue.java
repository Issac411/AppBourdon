package com.example.issac.ppe2sanskt.IHM;

import android.media.tv.TvView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.MODEL.specialisation;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.FutureTask;

public class specialisation_vue extends AppCompatActivity {
        TextView readAll; // ici code
        specialisation uneSpecialite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_vue);
        readAll = (TextView) findViewById(R.id.readAll);
        uneSpecialite = new specialisation();
        String url = uneSpecialite.urlGen("read");
        JSONObject res = new JSONObject();
        res = uneSpecialite.getJsonFromURL(url);
        JSONArray test = getAllObject(res);
        ArrayList<JSONObject> lesElements = JSONArrayToArray(test);
        ArrayList<specialisation> lesSpecisalitions = JSONArrayToSpecialisations(lesElements);
        readAll.setText(String.valueOf(lesSpecisalitions.get(1).getCode()));

    }



    protected ArrayList<JSONObject> JSONArrayToArray(JSONArray JSONArray) {
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

    protected ArrayList<specialisation> JSONArrayToSpecialisations(ArrayList<JSONObject> table) {
        ArrayList<specialisation> lesSpecialisations = new ArrayList<specialisation>();
        int i;
        for(i=0;i<table.size();i++) {
            specialisation laSpecialisation = new specialisation();
            laSpecialisation.putInObj(table.get(i));
            lesSpecialisations.add(laSpecialisation);
        }
        return lesSpecialisations;
    }



    protected int getElementInJSONArray(JSONArray json) {
        return json.length();
    }

    protected int getElementInJSONObject(JSONObject json) {
        return json.length();
    }

    protected JSONObject getOneObject(JSONObject object, int i) {
        ArrayList<String> jsonArray = new ArrayList<String>();
        JSONObject element;
        try {
            JSONArray interior = object.getJSONArray("res");
            JSONObject objectif = interior.getJSONObject(i);
            element = objectif;
        } catch (JSONException e) {
            element = new JSONObject();
            e.printStackTrace();
        }
        return element;
    }

    protected String getOneStringFromJSONObject(JSONObject object, int i) {
        ArrayList<String> jsonArray = new ArrayList<String>();
        String element;
        try {
            JSONArray interior = object.getJSONArray("res");
            String objectif = interior.getString(i);
            element = objectif;
        } catch (JSONException e) {
            element = "";
            e.printStackTrace();
        }
        return element;
    }

    protected JSONArray getAllObject(JSONObject object) {
        ArrayList<String> jsonArray = new ArrayList<String>();
        JSONArray element;
        try {
            element = object.getJSONArray("res");
        } catch (JSONException e) {
            element = new JSONArray();
            e.printStackTrace();
        }
        return element;
    }

    protected ArrayList<String> JsonObjectToArray(JSONObject json) {
        ArrayList table = new ArrayList<>();
        Iterator<?> keys = json.keys();
        while(keys.hasNext()) {
            String key = (String)keys.next();
            try {
                if(json.get(key) instanceof JSONObject) {


                } else {
                    table.add(String.valueOf(json.get(key)));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            }

        return table;



    }

}
