package com.example.issac.ppe2sanskt.IHM;

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
        JSONObject test = getOneObject(res,0);
        ArrayList<String> trucs = JsonObjectToArray(test);
        String size = String.valueOf(trucs.size());
        //uneSpecialite.putInObj(res);                   // le résultat va dans l'objet, j'ai modif importance pour le debug pour avoir le res sql
        //readAll.setText(uneSpecialite.getCode());
        //readAll.setText(Integer.toString(tall));
        readAll.setText(trucs.get(1).toString());

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

   /* protected ArrayList<String> JsonObjectToArray(JSONObject json) {
            int id = 0;
            String libelle = "0";
            String code = "0";
            try {
                id = json.getInt("id");
                libelle = json.getString("libelle");
                code = json.getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList table = new ArrayList<>();
            table.add(String.valueOf(id));
            table.add(String.valueOf(libelle));
            table.add(String.valueOf(code));
            return table;



        }*/

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
