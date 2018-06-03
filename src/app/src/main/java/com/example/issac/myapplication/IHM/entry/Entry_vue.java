package com.example.issac.myapplication.IHM.entry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.IHM.MainActivity;
import com.example.issac.myapplication.IHM.company.Company_details;
import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.myapplication.MODEL.Entry;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.myapplication.MODEL.LightEntry;
import com.example.issac.myapplication.MODEL.rows.EntryViewHolder;
import com.example.issac.myapplication.MODEL.rows.SimpleRow;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Entry_vue extends AppCompatActivity {

    private ListView listEntry;
    private ArrayList<Entry> lesEntry = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_vue);

        listEntry = (ListView) findViewById(R.id.listEntry);

        lesEntry = getLesEntry();

        EntryAdapter adapter = new EntryAdapter(Entry_vue.this,R.layout.row_entry,lesEntry);
        listEntry.setAdapter(adapter);

        listEntry.setOnItemClickListener(new AdapterView.OnItemClickListener() {            // si on clique sur un élément

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entry selectedRow = (Entry) listEntry.getItemAtPosition(position);               // on retrouve la row cliquée

                LightEntry entry_exported = new LightEntry(selectedRow);     // on passe cette spécialisation dans la prochaine activité
                Intent intent = new Intent(getApplicationContext(), Entry_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
                intent.putExtra("entry_exported", entry_exported);                   // "serializable"
                startActivity(intent);
            }

        });


    }

    private ArrayList<Entry> getLesEntry(){
        Entry uneEntry = new Entry();
        JSONObject res;
        String urlRealCommercial = uneEntry.urlGen("read");
        res = uneEntry.getJsonFromURL(urlRealCommercial);
        JSONArray jsonArrayEntry = uneEntry.getAllObject(res);
        ArrayList<JSONObject> lesElements = JSONAct.JSONArrayToArray(jsonArrayEntry);
        return uneEntry.JSONArrayToEntry(lesElements);
    }




}
