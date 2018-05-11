package com.example.issac.ppe2sanskt.IHM;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.issac.ppe2sanskt.MODEL.importance;
import com.example.issac.ppe2sanskt.MODEL.model;
import com.example.issac.ppe2sanskt.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class user_add extends AppCompatActivity {

    private importance uneImportance;
    private Button sender;
    private TextView gravite;
    private EditText resultat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);
        sender = (Button) findViewById(R.id.sender);
        gravite = (TextView) findViewById(R.id.gravite);
        resultat = (EditText) findViewById(R.id.resultat);

        // quand on clique sur le bouton d'envoi
            /*public void onClick(View v) {
                //uneImportance = new importance();
                //String content = gravite.getText().toString();
                //uneImportance.setContent(content);
            }*/

        sender.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton main_options
            public void onClick(View v) {
                uneImportance = new importance();
                String content = resultat.getText().toString();
                uneImportance.setContent(content);                                    // la fonction switchTo va changer l'activité
            }
        });



    }









    }

