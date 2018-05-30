package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.myapplication.MODEL.Practiced;
import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.myapplication.MODEL.radioRows.RadioRow;
import com.example.issac.myapplication.MODEL.radioRows.RadioRowAdapter;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Company_manage_specialisation extends AppCompatActivity {
    ListView mListView;
    TextView selected;
    Practiced link;
    boolean checked;
    ToggleButton Thebutton;

    Specialisation uneSpecialite;
    ArrayList<Specialisation> lesSpecialisations = new ArrayList<Specialisation>();
    ArrayList<Practiced> lesPratiques = new ArrayList<Practiced>();
    JSONObject res;
    int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_manage_specialisation);
        mListView = findViewById(R.id.listView);
        Intent intent = getIntent();
        LightCompany imported = (LightCompany) intent.getSerializableExtra("lightCompany_exported");
        uneSpecialite = new Specialisation();
        String url = uneSpecialite.urlGen("read");
        res = uneSpecialite.getJsonFromURL(url);               // avec la requête en url, on récupére dans un JSON le résultat
        JSONArray test = uneSpecialite.getAllObject(res);                    // le tableau JSON dans l'objet JSON est récupéré
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(test);     // On transforme le JSONArray en array tout court
        lesSpecialisations = uneSpecialite.JSONArrayToSpecialisations(lesElements);     // le Array ne contient plus du JSON mais des objets
        List<RadioRow> rows = new ArrayList<RadioRow>();
        ToggleButton leButton = new ToggleButton(this);
        leButton.setChecked(true);
        rows.add(new RadioRow( lesSpecialisations.get(i).getLibelle(), leButton));

        for (i = 0; i < lesSpecialisations.size(); i++) {
            rows.add(new RadioRow( lesSpecialisations.get(i).getLibelle(), new ToggleButton(this)));
        }
        RadioRowAdapter adapter = new RadioRowAdapter(this,rows);          // affichage de la liste
        mListView.setAdapter(adapter);

    }
}
