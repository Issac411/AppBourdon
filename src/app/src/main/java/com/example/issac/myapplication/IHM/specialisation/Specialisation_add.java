package com.example.issac.myapplication.IHM.specialisation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;

public class Specialisation_add extends AppCompatActivity {

    private Specialisation uneSpecialisation;
    private Button creation;
    private TextView specialisationLibelle;         // le texte non éditable
    private TextView specialisationCode;
    private EditText specialisationLibelleField;        // le texte que l'utilisateur compléte
    private EditText specialisationCodeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_add);
        creation = (Button) findViewById(R.id.creation);
        specialisationLibelle = (TextView) findViewById(R.id.vue_specialisation_libelle);
        specialisationLibelleField = (EditText) findViewById(R.id.specialisation_libelle);
        specialisationCode = (TextView) findViewById(R.id.vue_specialisation_code);
        specialisationCodeField = (EditText) findViewById(R.id.specialisation_code);

        creation.setOnClickListener(new View.OnClickListener() {            // quand on clique sur le bouton main_options
            public void onClick(View v) {
                JSONObject res = new JSONObject();
                uneSpecialisation = new Specialisation();
                String url = uneSpecialisation.urlGen("create",specialisationLibelleField.getText().toString(),specialisationCodeField.getText().toString());     // on prépare l'url pour la requête en fonction de l'action voulue + champ écrit
                specialisationLibelle.setText(url);               // debug url
                res = uneSpecialisation.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
                uneSpecialisation.putInObj(res);                   // le résultat va dans l'objet, j'ai modif importance pour le debug pour avoir le res sql
                //gravite.setText(url);    // on affiche true or false


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
