package com.example.issac.myapplication.IHM;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.issac.myapplication.MODEL.Importance;
import com.example.issac.myapplication.MODEL.Model;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;

public class User_add extends AppCompatActivity {

    private Importance uneImportance;
    private Button sender;
    private TextView gravite; // texte final
    private EditText resultat; // texte à compléter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);
        sender = (Button) findViewById(R.id.sender);
        gravite = (TextView) findViewById(R.id.gravite);
        resultat = (EditText) findViewById(R.id.resultat);

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


            }
        });



    }









    }

