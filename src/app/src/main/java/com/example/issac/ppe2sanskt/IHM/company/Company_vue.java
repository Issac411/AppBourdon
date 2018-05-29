package com.example.issac.ppe2sanskt.IHM.company;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.CONFIG.JSONAct;
import com.example.issac.ppe2sanskt.IHM.specialisation.Specialisation_vue;
import com.example.issac.ppe2sanskt.MODEL.Company;
import com.example.issac.ppe2sanskt.MODEL.LightCompany;
import com.example.issac.ppe2sanskt.MODEL.rows.SimpleRow;
import com.example.issac.ppe2sanskt.MODEL.rows.SimpleRowAdapter;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        selected = (TextView) findViewById(R.id.selected);
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










        company_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchTo_company_add();
            }
        });
    }




    public void switchTo_company_add() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.company.Company_add.class);
        startActivity(intent);
    }
}
