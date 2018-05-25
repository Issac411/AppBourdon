package com.example.issac.ppe2sanskt.IHM;

import android.content.Intent;
import android.database.Cursor;
import android.media.tv.TvView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
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
        ListView mListView;
        TextView selected;
        specialisation uneSpecialite;
        ArrayList<String> lesLibelles = new ArrayList<String>();
        ArrayList<String> lesIds = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_vue);
        mListView = (ListView) findViewById(R.id.listView);
        selected = (TextView) findViewById(R.id.selected);

        JSONObject res;
        int i;

        uneSpecialite = new specialisation();
        String url = uneSpecialite.urlGen("read");      // on produit une requête de lecture de toutes les spécialités car il n'y a que read, pas de params en plus
        res = uneSpecialite.getJsonFromURL(url);               // avec la requête en url, on récupére dans un JSON le résultat
        JSONArray test = getAllObject(res);                    // le tableau JSON dans l'objet JSON est récupéré
        ArrayList<JSONObject> lesElements = JSONArrayToArray(test);     // On transforme le JSONArray en array tout court
        ArrayList<specialisation> lesSpecialisations = uneSpecialite.JSONArrayToSpecialisations(lesElements);     // le Array ne contient plus du JSON mais des objets


        for(i = 0; i < lesSpecialisations.size();i++) {
            lesLibelles.add(lesSpecialisations.get(i).getLibelle());        // on fait un tableau de libelles en chopant les objets
            lesIds.add(String.valueOf(lesSpecialisations.get(i).getId()));
            // POINTE L ID ET DEBUG L APP
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(specialisation_vue.this,      // on fait la liste
                android.R.layout.simple_list_item_1, lesLibelles);
        mListView.setAdapter(adapter);      // boom


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String theString = (String)mListView.getItemAtPosition(position);
                selected.setText(String.valueOf(lesIds.size()));
                boolean found = false;
                int i = 0;
                String specialisationId = "";
                while(!found) {
                    if(i == lesIds.size()) {
                       found = true;
                    }
                    if(lesLibelles.get(i) == theString) {
                        specialisationId = lesIds.get(i);
                        found = true;
                    }
                    i++;
                }
                Intent intent = new Intent(getApplicationContext(), specialisation_details.class);
                intent.putExtra("specialisationLibelle",theString);
                intent.putExtra("specialisationId",specialisationId);
                startActivity(intent);
            }




            });
    }

    /* Matthieu
    24/05/18
    Retourne un tableau d'objets en JSON
    Permet de convertir les JSONArray en Array tout court
     */
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




    /* Matthieu
    24/05/18
    Retourne un int
    récupère la taille d'un JSONArray
    */
    protected int getElementInJSONArray(JSONArray json) {
        return json.length();
    }

    /* Matthieu
    24/05/18
    Retourne un int
    récupère la taille d'un JSONAObject
    */
    protected int getElementInJSONObject(JSONObject json) {
        return json.length();
    }


    /* Matthieu
    24/05/18
    retourne un JSONObject
    Retourne un JSONObject contenu dans un autre JSONObject, on pointe avec un index
    */
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


    /* Matthieu
    24/05/18
    retourne un String
    Récupère un certain élément du JSONObject passé en param selon l'index
    */
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


    /* Matthieu
    24/05/18
    retourne un JSONOArray
    Avec l'objet JSON passé en param, retourne le tableau qu'il contient si il en existe un sous le nom de "res"
    */
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


    /* Matthieu
    24/05/18
    retourne une liste de chaines
    récupère les éléments d'un JSONObject pour les loger dans un tableau
    */
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
