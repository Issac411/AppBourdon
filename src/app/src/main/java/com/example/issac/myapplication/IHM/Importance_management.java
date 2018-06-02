package com.example.issac.myapplication.IHM;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.IHM.company.Company_manage_specialisation;
import com.example.issac.myapplication.MODEL.Importance;
import com.example.issac.myapplication.MODEL.Model;
import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.myapplication.MODEL.radioRows.RadioRow;
import com.example.issac.myapplication.MODEL.radioRows.RadioRowAdapter;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/*
importe : 0
Formulaire d'ajout d'une importance
*/

public class Importance_management extends AppCompatActivity {

    private Importance uneImportance;
    private Button sender;
    private TextView gravite; // texte final
    private EditText resultat; // texte à compléter
    private ListView mListView;
    private ListView mListView2;
    private Button delete_importances;
    private View specific_row;
    private TextView specificName;
    JSONObject importance_JSON = new JSONObject();
    JSONArray importance_JSONArray = new JSONArray();
    ArrayList<JSONObject> importances_JSON_array = new ArrayList<JSONObject>();
    ArrayList<Importance> lesImportances = new ArrayList<Importance>();
    Importance limportance = new Importance();
    ArrayList<RadioRow> rowsSelected = new ArrayList<>();
    int i;
    ArrayList<RadioRow> rows = new ArrayList<>();
    String url;
    Boolean occurence = false;
    Boolean found = false;
    int idImportance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importance_management);
        sender = (Button) findViewById(R.id.sender);
        gravite = (TextView) findViewById(R.id.gravite);
        resultat = (EditText) findViewById(R.id.resultat);
        mListView = (ListView) findViewById(R.id.mListView);
        mListView2 = (ListView) findViewById(R.id.mListView2);
        delete_importances = (Button) findViewById(R.id.delete_importances);
        url = limportance.urlGen("read");                                                         // get all specialisations to create a list
        importance_JSON = limportance.getJsonFromURL(url);                                            //
        importance_JSONArray = limportance.getAllObject(importance_JSON);                         //
        importances_JSON_array = JSONAct.JSONArrayToArray(importance_JSONArray);                        //
        lesImportances = limportance.JSONArrayToImportances(importances_JSON_array);           // <- JSONObject[JSONArray(JSONobj1)(JSONobj2)...]] TO -> ArrayList[(obj1)(obj2)...]
        for(i=0;i<lesImportances.size();i++) {

            rows.add(new RadioRow(lesImportances.get(i).getContent(),true));                         // Chaque spécialisation aura une ligne dans le tableau.
            //testView.setText(rows.get(i).getName());// brr test
        }
        RadioRowAdapter adapter = new RadioRowAdapter(Importance_management.this, rows);          // affichage de la liste
        mListView.setAdapter(adapter);


        sender.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton main_options
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                JSONObject res = new JSONObject();
                uneImportance = new Importance();
                String url = uneImportance.urlGen("create",resultat.getText().toString());     // on prépare l'url pour la requête en fonction de l'action voulue + champ écrit
                gravite.setText(url);               // debug url
                res = uneImportance.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
                uneImportance.putInObj(res);                   // le résultat va dans l'objet, j'ai modif importance pour le debug pour avoir le res sql
                gravite.setText(url);    // on affiche true or false
                Intent intent = new Intent(getApplicationContext(), Importance_management.class);          // Pour sa on la loge dans une classe légère compatible avec le
                startActivity(intent);

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


           /*
             Matthieu
             01/06
             retourne
             entrée est la liste actuelle, la vue (importance_add), la position dans la liste de l'objet selectionné et son id.
             Permet d'ajouter un élément dans la liste mListView2 qui servira de liste de suppression
            */

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RadioRow selectedRow = (RadioRow) mListView.getItemAtPosition(position);               // on retrouve la row cliquée
                for(i=0;i<rowsSelected.size();i++) {
                    if(rowsSelected.get(i).getName() == selectedRow.getName()) {
                        occurence = true;
                    }
                }
                if(occurence == false) {
                    rowsSelected.add(selectedRow);
                    RadioRowAdapter adapter2 = new RadioRowAdapter(Importance_management.this, rowsSelected);          // affichage de la liste
                    mListView2.setAdapter(adapter2);
                }

            }
        });

                    /*
            Matthieu
            01/06
            Lors du clic sur le bouton, la liste N°2 contenant les importances selectionnées va se faire supprimer dans une boucle.
             */
        delete_importances.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(i=0;i<mListView2.getCount();i++) {
                    specific_row = mListView2.getAdapter().getView(i, null, mListView2);
                    specificName =  specific_row.findViewById(R.id.name);
                    for(i=0;i<lesImportances.size();i++) {
                        if(specificName.getText() == lesImportances.get(i).getContent()) {
                            idImportance = lesImportances.get(i).getId();
                        }
                    }
                    url = limportance.urlGen("delete",String.valueOf(idImportance));
                    JSONObject nullThing = limportance.getJsonFromURL(url);
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);          // Pour sa on la loge dans une classe légère compatible avec le
                startActivity(intent);

            }
        });



    }









}

