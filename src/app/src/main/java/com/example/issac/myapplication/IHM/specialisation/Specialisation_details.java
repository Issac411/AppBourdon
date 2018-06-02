package com.example.issac.myapplication.IHM.specialisation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.issac.myapplication.MODEL.LightSpecialisation;
import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.ppe2sanskt.R;

public class Specialisation_details extends AppCompatActivity {
    TextView specialisationId;
    TextView specialisationLibelle;
    Button specialisationDelete;
    Specialisation laSpecialisation = new Specialisation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_details);
        specialisationLibelle = (TextView)  findViewById(R.id.specialisationLibelle);
        specialisationId = (TextView)  findViewById(R.id.specialisationId);
        specialisationDelete = (Button) findViewById(R.id.specialisationDelete);

        Intent intent = getIntent();

        LightSpecialisation specilisation_exported = (LightSpecialisation) intent.getSerializableExtra("specilisation_exported");
            specialisationId.setText(specilisation_exported.getCode().toString());
            specialisationLibelle.setText(specilisation_exported.getLibelle().toString());


        specialisationDelete.setOnClickListener(new View.OnClickListener() {         // quand on clique sur le bouton d'ajout
            public void onClick(View v) {
                specialisationDelete(specilisation_exported);
            }
        });

    }

    public void specialisationDelete(LightSpecialisation specilisation_exported) {
        String url = laSpecialisation.urlGen("delete",String.valueOf(specilisation_exported.getId()));
        laSpecialisation.getJsonFromURL(url);
        Intent intent = new Intent(getApplicationContext(), Specialisation_vue.class);          // Pour sa on la loge dans une classe légère compatible avec le
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
