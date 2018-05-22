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
        TextView readAll;
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
        String test = specialisationArray(res);
        //uneSpecialite.putInObj(res);                   // le résultat va dans l'objet, j'ai modif importance pour le debug pour avoir le res sql
        //readAll.setText(uneSpecialite.getCode());
        readAll.setText(test);

    }

    protected String specialisationArray(JSONObject object) {
        ArrayList<String> jsonArray = new ArrayList<String>();
        String element = "";
        try {
            JSONArray interior = object.getJSONArray("res");
            JSONObject objectif = interior.getJSONObject(0);
            element = objectif.toString();
        } catch (JSONException e) {
            element = "prout";
            e.printStackTrace();
        }
        return element;
    }
}
