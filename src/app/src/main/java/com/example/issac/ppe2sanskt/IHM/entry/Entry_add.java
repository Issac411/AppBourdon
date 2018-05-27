package com.example.issac.ppe2sanskt.IHM.entry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.MODEL.Commercial;
import com.example.issac.ppe2sanskt.MODEL.Company;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;

public class Entry_add extends AppCompatActivity {
    TextView commercial_selected = (TextView)findViewById(R.id.commercial_selected);
    Button commercial_selector = (Button) findViewById(R.id.commercial_selector);
    TextView company_selected = (TextView)findViewById(R.id.company_selected);
    Button company_selector = (Button) findViewById(R.id.company_selector);
    EditText date = (EditText) findViewById(R.id.date);
    TextView duration = (TextView) findViewById(R.id.duration);
    EditText duration_field = (EditText) findViewById(R.id.duration_field);
    TextView comment = (TextView) findViewById(R.id.comment);
    EditText comment_field = (EditText) findViewById(R.id.comment_field);
    Button creation = (Button) findViewById(R.id.creation);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_add);
        commercial_selected = (TextView)findViewById(R.id.commercial_selected);
        commercial_selector = (Button) findViewById(R.id.commercial_selector);
        company_selected = (TextView)findViewById(R.id.company_selected);
        company_selector = (Button) findViewById(R.id.company_selector);
        date = (EditText) findViewById(R.id.date);
        duration = (TextView) findViewById(R.id.duration);
        duration_field = (EditText) findViewById(R.id.duration_field);
        comment = (TextView) findViewById(R.id.comment);
        comment_field = (EditText) findViewById(R.id.comment_field);
        creation = (Button) findViewById(R.id.creation);

        creation.setOnClickListener(new View.OnClickListener() {            // quand on clique sur le bouton main_options
            public void onClick(View v) {
                Company uneCompany = new Company();
                Commercial leCommercial = new Commercial();
                Intent intent = new Intent(getApplicationContext(), Entry_addSelectCompany.class);          // Pour sa on la loge dans une classe légère compatible avec le                 // "serializable"
                startActivity(intent);


            }
        });


    }

}
