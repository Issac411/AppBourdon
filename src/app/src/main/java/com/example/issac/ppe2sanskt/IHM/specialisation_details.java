package com.example.issac.ppe2sanskt.IHM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.R;

public class specialisation_details extends AppCompatActivity {
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
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            var_specialisationLibelle = extras.getString("specialisationLibelle");
            var_specialisationId = extras.getString("specialisationId");
        }



        specialisationLibelle.setText(var_specialisationLibelle);
        specialisationId.setText(var_specialisationId);


    }
}
