package com.example.issac.myapplication.IHM.entry;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.IHM.company.Company_vue;
import com.example.issac.myapplication.MODEL.Commercial;
import com.example.issac.myapplication.MODEL.Entry;
import com.example.issac.myapplication.MODEL.Importance;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.SortedMap;

public class Entry_add extends AppCompatActivity {

    private Entry laVisite = new Entry();
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();
    Timestamp timestamp = new Timestamp(0,0,0,0,0,0,0);
    private TextView txtDateTime;
    private TextView txtCompany;
    private TextView txtDuration;
    private TextView txtComment;
    private Spinner spinnerCommercial;
    private Spinner spinnerImportance;
    private Button btnTime;
    private Button btnDate;
    private Button btnCreation;
    private LightCompany importedCompany;
    private ArrayList<Commercial> listCommercial = new ArrayList<>();
    private ArrayList<Importance> listImportance = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_add);
        Intent intent = getIntent();

        txtDateTime = (TextView) findViewById(R.id.txt_date);
        txtCompany = (TextView) findViewById(R.id.txtCompany);
        txtDuration = (TextView) findViewById(R.id.txtDuration);
        txtComment = (TextView) findViewById(R.id.txtComment);
        spinnerCommercial = (Spinner) findViewById(R.id.spinnerCommercial);
        spinnerImportance = (Spinner) findViewById(R.id.spinnerImportance);
        btnTime = (Button) findViewById(R.id.btn_time);
        btnDate = (Button) findViewById(R.id.btn_date);
        btnCreation = (Button) findViewById(R.id.btn_creation);
        importedCompany = (LightCompany) intent.getSerializableExtra("exportedCompany");

        txtCompany.setText(String.valueOf(importedCompany.getName()));


        listImportance = getListImportance();
        listCommercial = getListCommercial();

        //Remplissage de la liste du spinner pour les commerciales
        List lesCommercials = new ArrayList();
        for(Commercial com : listCommercial){
            lesCommercials.add(com.getNickName() + " " + com.getName());
        }

        ArrayAdapter adapterCommercial = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item,lesCommercials
        );

        adapterCommercial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCommercial.setAdapter(adapterCommercial);

        //Remplissage de la liste du spinner pour les importances
        List lesImportances = new ArrayList();
        for(Importance imp : listImportance){
            lesImportances.add(imp.getContent());
        }

        ArrayAdapter adapterImportance = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item,lesImportances
        );

        adapterImportance.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerImportance.setAdapter(adapterImportance);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTime();
            }
        });

        btnCreation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                creationEntry();
            }
        });


        UpdateText();
    }


    //Ouvre un calendrier pour selectionner la date
    private void updateDate(){
        new DatePickerDialog(this, d, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    //Ouvre une horloge pour selectionenr l'heure
    private void updateTime(){
        new TimePickerDialog(this, t, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
    }


    //update le dateTime
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            UpdateText();
        }
    };


    //update le dateTime
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            dateTime.set(Calendar.SECOND, 0);
            UpdateText();
        }
    };



    private ArrayList<Importance> getListImportance(){
        Importance uneImportance = new Importance();
        JSONObject resReadCommercial;
        String urlRealCommercial = uneImportance.urlGen("read");
        resReadCommercial = uneImportance.getJsonFromURL(urlRealCommercial);
        JSONArray jsonArrayCommercial = uneImportance.getAllObject(resReadCommercial);
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(jsonArrayCommercial);
        return uneImportance.JSONArrayToImportances(lesElements);
    }


    private ArrayList<Commercial> getListCommercial(){
        Commercial unCommercial = new Commercial();
        JSONObject resReadCommercial;
        String urlRealCommercial = unCommercial.urlGen("read");
        resReadCommercial = unCommercial.getJsonFromURL(urlRealCommercial);
        JSONArray jsonArrayCommercial = unCommercial.getAllObject(resReadCommercial);
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(jsonArrayCommercial);
        return unCommercial.JSONArrayToCommercials(lesElements);
    }




    //update le text view montrant la date selectionner
    private void UpdateText(){
        txtDateTime.setText(formatDateTime.format(dateTime.getTime()));
        timestamp.setYear(dateTime.get(Calendar.YEAR)-1900);
        timestamp.setMonth(dateTime.get(Calendar.MONTH));
        timestamp.setDate(dateTime.get(Calendar.DAY_OF_MONTH));
        timestamp.setHours(dateTime.get(Calendar.HOUR_OF_DAY));
        timestamp.setMinutes(dateTime.get(Calendar.MINUTE));
    }

    private void setLaVisite(){
        laVisite.setIdcompany(importedCompany.getId());
        laVisite.setIdcommercial(listCommercial.get(spinnerCommercial.getSelectedItemPosition()).getId());
        laVisite.setIdimportance(listImportance.get(spinnerImportance.getSelectedItemPosition()).getId());
        laVisite.setDate(timestamp);
        laVisite.setComment(txtComment.getText().toString());
        laVisite.setDuration(Integer.parseInt(txtDuration.getText().toString(),10));
        laVisite.setStatus("Programmer");
    }


    private void creationEntry(){
        setLaVisite();
        laVisite.create();
        Intent intent = new Intent(getApplicationContext(), Company_vue.class);
        startActivity(intent);
    }

}
