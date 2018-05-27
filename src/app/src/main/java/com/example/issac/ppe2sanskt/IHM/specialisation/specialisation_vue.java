package com.example.issac.ppe2sanskt.IHM.specialisation;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Random;
import com.example.issac.ppe2sanskt.CONFIG.JSONAct;
import com.example.issac.ppe2sanskt.MODEL.LightSpecialisation;

import com.example.issac.ppe2sanskt.MODEL.Model;
import com.example.issac.ppe2sanskt.MODEL.rows.SimpleRow;
import com.example.issac.ppe2sanskt.MODEL.rows.simpleRowAdapter;
import com.example.issac.ppe2sanskt.MODEL.Specialisation;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Specialisation_vue extends AppCompatActivity implements JSONAct {
    ListView mListView;
    TextView selected;
    Specialisation uneSpecialite;
    ArrayList<Specialisation> lesSpecialisations = new ArrayList<Specialisation>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_vue);
        mListView = (ListView) findViewById(R.id.listView);
        selected = (TextView) findViewById(R.id.selected);
        Random rand = new Random();

        JSONObject res;
        int i;

        uneSpecialite = new Specialisation();
        String url = uneSpecialite.urlGen("read");      // on produit une requête de lecture de toutes les spécialités car il n'y a que read, pas de params en plus
        res = uneSpecialite.getJsonFromURL(url);               // avec la requête en url, on récupére dans un JSON le résultat
        JSONArray test = uneSpecialite.getAllObject(res);                    // le tableau JSON dans l'objet JSON est récupéré
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(test);     // On transforme le JSONArray en array tout court
        lesSpecialisations = uneSpecialite.JSONArrayToSpecialisations(lesElements);     // le Array ne contient plus du JSON mais des objets

        List<SimpleRow> rows = new ArrayList<SimpleRow>();
        for(i = 0; i < lesSpecialisations.size();i++) {
            int color = rand.nextInt();
            rows.add(new SimpleRow(color, lesSpecialisations.get(i).getLibelle(), lesSpecialisations.get(i).getCode()));      // on peuple chaque row avec le libelle, le code et une couleur random
        }



        simpleRowAdapter adapter = new simpleRowAdapter(Specialisation_vue.this,rows);          // affichage de la liste
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {            // si on clique sur un élément

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleRow selectedRow = (SimpleRow)mListView.getItemAtPosition(position);               // on retrouve la row cliquée
                boolean found = false;
                int i = 0;
                Specialisation laSpecialisation = new Specialisation();
                while(!found) {                                                     // On cherche à quelle spécialisation elle fait référence
                    if(i == lesSpecialisations.size()) {
                        found = true;
                    }
                    if(lesSpecialisations.get(i).getLibelle() == selectedRow.getName()) {
                        laSpecialisation = lesSpecialisations.get(i);
                        found = true;
                    }
                    i++;
                }
                LightSpecialisation specilisation_exported = new LightSpecialisation(laSpecialisation);     // on passe cette spécialisation dans la prochaine activité
                Intent intent = new Intent(getApplicationContext(), specialisation_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
                intent.putExtra("specilisation_exported", specilisation_exported);                   // "serializable"
                startActivity(intent);
            }

        });
    }




}
