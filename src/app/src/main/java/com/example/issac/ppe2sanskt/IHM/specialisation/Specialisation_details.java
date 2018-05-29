package com.example.issac.ppe2sanskt.IHM.specialisation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.MODEL.LightSpecialisation;
import com.example.issac.ppe2sanskt.MODEL.Specialisation;
import com.example.issac.ppe2sanskt.R;

public class Specialisation_details extends AppCompatActivity {
    TextView specialisationId;
    TextView specialisationLibelle;
    String var_specialisationLibelle = "";
    String var_specialisationId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialisation_details);
        specialisationLibelle = (TextView)  findViewById(R.id.specialisationLibelle);
        specialisationId = (TextView)  findViewById(R.id.specialisationId);
        Intent intent = getIntent();
        //Person Person = (Person) intent.getSerializableExtra("Person");

        LightSpecialisation specilisation_exported = (LightSpecialisation) intent.getSerializableExtra("specilisation_exported");
            specialisationId.setText(specilisation_exported.getCode().toString());
            specialisationLibelle.setText(specilisation_exported.getLibelle().toString());



    }
}
