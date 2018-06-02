package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.myapplication.MODEL.rows.SimpleRow;
import com.example.issac.myapplication.MODEL.rows.SimpleRowAdapter;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
importe : 0
Contient le formulaire d'ajout d'une entreprise, aucun import car champs vierges.
Lors de la validation, une url est gen et met en place une requête PHP pour l'ajout en base.

 */

public class Company_vue extends AppCompatActivity {
    ListView mListView;
    TextView selected;
    Company uneCompany;
    Button company_add;
    ArrayList<Company> lesCompanies = new ArrayList<Company>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_vue);
        mListView = (ListView) findViewById(R.id.listView);
        company_add = (Button) findViewById(R.id.company_add);
        Random rand = new Random();
        JSONObject res;
        int i;
        uneCompany = new Company();
        String url = uneCompany.urlGen("read");      // on produit une requête de lecture de toutes les companies
        res = uneCompany.getJsonFromURL(url);               // avec la requête en url, on récupére dans un JSON le résultat
        JSONArray test = uneCompany.getAllObject(res);                    // le tableau JSON dans l'objet JSON est récupéré
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(test);     // On transforme le JSONArray en array tout court
        lesCompanies = uneCompany.JSONArrayToCompanies(lesElements);     // le Array ne contient plus du JSON mais des objets
        List<SimpleRow> rows = new ArrayList<SimpleRow>();
        for (i = 0; i < lesCompanies.size(); i++) {
            int color = rand.nextInt();
            rows.add(new SimpleRow(color, lesCompanies.get(i).getName(), lesCompanies.get(i).getInterName() + " " + lesCompanies.get(i).getInterNickName() + " [" + lesCompanies.get(i).getNum() + "]"));
        }
        SimpleRowAdapter adapter = new SimpleRowAdapter(Company_vue.this, rows);          // affichage de la liste
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {            // si on clique sur un élément

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleRow selectedRow = (SimpleRow)mListView.getItemAtPosition(position);               // on retrouve la row cliquée
                boolean found = false;
                int i = 0;
                Company uneCompany = new Company();
                while(!found) {                                                     // On cherche à quelle spécialisation elle fait référence
                    if(i == lesCompanies.size()) {
                        found = true;
                    }
                    if(lesCompanies.get(i).getName() == selectedRow.getName()) {
                        uneCompany = lesCompanies.get(i);
                        found = true;
                    }
                    i++;
                }
                LightCompany company_exported = new LightCompany(uneCompany);     // on passe cette spécialisation dans la prochaine activité
                Intent intent = new Intent(getApplicationContext(), Company_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
                intent.putExtra("lightCompany_exported", company_exported);                   // "serializable"
                startActivity(intent);
            }

        });










        company_add.setOnClickListener(new View.OnClickListener() {         // quand on clique sur le bouton d'ajout
            public void onClick(View v) {
                switchTo_company_add();
            }
        });
    }




    public void switchTo_company_add() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.company.Company_add.class);        // changement d'activité
        startActivity(intent);
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
