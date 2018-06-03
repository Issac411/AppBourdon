package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.myapplication.MODEL.Practiced;
import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.myapplication.MODEL.radioRows.RadioRow;
import com.example.issac.myapplication.MODEL.radioRows.RadioRowAdapter;
import com.example.issac.myapplication.MODEL.rows.SimpleRowAdapter;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.List;

/*
importe : lightCompany de Company_details
contient deux tableaux : celui des spécialités et un second, vide, qui va contenir les activités désirées par l'utilisateur.
Lors de la validation par l'unique bouton, l'id de l'entreprise est récupérée par le lightCompany "lightCompany_exported"

 */
public class Company_manage_specialisation extends AppCompatActivity {
    JSONObject specialisation_JSON = new JSONObject();
    JSONArray specialisation_JSONArray = new JSONArray();
    ArrayList<JSONObject> specialisations_JSON_array = new ArrayList<JSONObject>();
    ArrayList<Specialisation> lesSpecialistions = new ArrayList<Specialisation>();
    Specialisation uneSpecialisation = new Specialisation();
    String url = "nothing";
    int i = 0;
    int i2 = 0;
    ArrayList<RadioRow> rows = new ArrayList<>();               // déclaration et instanciations des variables et tableaux
    ListView mListView;
    Button set;
    TextView specificName;
    CheckBox specificCheckbox;
    View specific_row;
    String name;
    Boolean isChecked;
    int idSpecialisation;
    int idCompany;
    ArrayList<RadioRow> rowsSelected = new ArrayList<>();
    ListView mListView2;
    Boolean occurence = false;
    Boolean found =false;
    Practiced pratique = new Practiced();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_manage_specialisation);
        Intent intent = getIntent();
        mListView = (ListView) findViewById(R.id.mListView);
        mListView2 = (ListView) findViewById(R.id.mListView2);
        set = (Button) findViewById(R.id.set);
        LightCompany imported = (LightCompany) intent.getSerializableExtra("lightCompany_exported");     // get the company
        url = uneSpecialisation.urlGen("read");                                                         // get all specialisations to create a list
        specialisation_JSON = uneSpecialisation.getJsonFromURL(url);                                            //
        specialisation_JSONArray = uneSpecialisation.getAllObject(specialisation_JSON);                         //
        specialisations_JSON_array = JSONAct.JSONArrayToArray(specialisation_JSONArray);                        //
        lesSpecialistions = uneSpecialisation.JSONArrayToSpecialisations(specialisations_JSON_array);           // <- JSONObject[JSONArray(JSONobj1)(JSONobj2)...]] TO -> ArrayList[(obj1)(obj2)...]

        for(i=0;i<lesSpecialistions.size();i++) {

            rows.add(new RadioRow(lesSpecialistions.get(i).getLibelle(),true));                         // Chaque spécialisation aura une ligne dans le tableau.
        }
        RadioRowAdapter adapter = new RadioRowAdapter(this, rows);          // affichage de la liste
        mListView.setAdapter(adapter);
        i=0;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {





           /*
             Matthieu
             01/06
             retourne
             entrée est la liste actuelle, la vue (activity_company_manage_specialisation), la position dans la liste de l'objet selectionné et son id.
             Permet d'ajouter une spécialité dans le tableau des spécialités selectionnés
            */

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RadioRow selectedRow = (RadioRow) mListView.getItemAtPosition(position);               // on retrouve la row cliquée
                for(i2=0;i2<rowsSelected.size();i2++) {
                    if(rowsSelected.get(i2).getName() == selectedRow.getName()) {
                        occurence = true;
                    }
                }
                if(occurence == false) {
                    rowsSelected.add(selectedRow);
                    RadioRowAdapter adapter2 = new RadioRowAdapter(Company_manage_specialisation.this, rowsSelected);          // affichage de la liste
                    mListView2.setAdapter(adapter2);
                }

            }
        });

            /*
            Matthieu
            01/06
            Lors du clic sur le bouton, la liste N°2 contenant les spécialités sélectionnés
             */
        set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(i=0;i<mListView2.getCount();i++) {
                    specific_row = mListView2.getAdapter().getView(i, null, mListView2);
                    specificName =  specific_row.findViewById(R.id.name);
                    i2=0;
                    while(found == false) {
                        if(specificName.getText() == lesSpecialistions.get(i2).getLibelle()) {
                            idSpecialisation = lesSpecialistions.get(i2).getId();
                            String url = pratique.urlGen("create",String.valueOf(idSpecialisation),String.valueOf(imported.getId()));
                            specialisation_JSON = pratique.getJsonFromURL(url);
                            found = true;
                        } else {
                            if(lesSpecialistions.size() == i2) {
                                found=true;
                            } else {
                                i2++;
                            }
                        }
                    }
                    found = false;
                    Intent intent = new Intent(getApplicationContext(), Company_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
                    intent.putExtra("lightCompany_exported", imported);                   // "serializable"
                    startActivity(intent);
                }

            }
        });



        }

    /*
    Matthieu
    02/06
    retourne des booléans true
    Mise en forme du bouton superieur du menu
    */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        //Button retourMenu = (Button) findViewById(R.id.action_bar);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.MainActivity.class);
        startActivity(intent);
        return true;
    }

}