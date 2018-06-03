package com.example.issac.myapplication.IHM.entry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.issac.myapplication.MODEL.Entry;
import com.example.issac.myapplication.MODEL.LightEntry;
import com.example.issac.ppe2sanskt.R;

public class Entry_details extends AppCompatActivity {

    private Entry uneEntry;

    private TextView txtCompany;
    private TextView txtCommercial;
    private TextView txtImportance;
    private TextView txtDateTime;
    private TextView txtComment;
    private TextView txtDuration;
    private TextView txtStatus;
    private Button btnAnnuler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_details);
        Intent intent = getIntent();

        txtCompany = (TextView) findViewById(R.id.txtCompany);
        txtCommercial = (TextView) findViewById(R.id.txtCommercial);
        txtImportance = (TextView) findViewById(R.id.txtImportance);
        txtDateTime = (TextView) findViewById(R.id.txtDateTime);
        txtComment = (TextView) findViewById(R.id.txtComment);
        txtDuration = (TextView) findViewById(R.id.txtDuration);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        btnAnnuler = (Button) findViewById(R.id.btnAnnuler);


        LightEntry entry_imported = (LightEntry) intent.getSerializableExtra("entry_exported");
        uneEntry = new Entry(entry_imported);

        txtCompany.setText(uneEntry.getCompany().getName());
        txtCommercial.setText(uneEntry.getCommercial().getName());
        txtDateTime.setText(uneEntry.getDate().toString());
        txtComment.setText(uneEntry.getComment().toString());
        txtDuration.setText(String.valueOf(uneEntry.getDuration()));
        txtImportance.setText(uneEntry.getImportance().getContent());
        txtStatus.setText(uneEntry.getStatus());

        btnAnnuler.setOnClickListener(new View.OnClickListener() {            // quand on clique sur le bouton
            public void onClick(View v) {
                uneEntry.ChangerStatus("ANNULEE");
                LightEntry entry_exported = new LightEntry(uneEntry);
                Intent intent = new Intent(getApplicationContext(), Entry_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
                intent.putExtra("entry_exported", entry_exported);                   // "serializable"
                startActivity(intent);
                finish();
            }
        });


    }
}
