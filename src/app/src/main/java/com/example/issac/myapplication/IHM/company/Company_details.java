package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.issac.myapplication.IHM.specialisation.Specialisation_add;
import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;


public class Company_details extends AppCompatActivity {
    private TextView companyName;
    private TextView companyAddress1;
    private TextView companyAddress2;
    private TextView companyPc;
    private TextView companyCity;
    private TextView companyNum;
    private TextView companyInterName_NickName;
    private TextView companyInterNum;
    private TextView companyInterMail;
    private Button suppression;
    private Button edit;
    private Button specialisation;
    private Button btnEntryAdd;



    Button goToMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        Intent intent = getIntent();
        companyName = (TextView) findViewById(R.id.companyName);
        companyAddress1 = (TextView) findViewById(R.id.companyAddress1);
        companyAddress2 = (TextView) findViewById(R.id.companyAddress2);
        companyPc = (TextView) findViewById(R.id.companyCp);
        companyCity = (TextView) findViewById(R.id.companyCity);
        companyNum = (TextView) findViewById(R.id.companyNum);
        companyInterName_NickName = (TextView) findViewById(R.id.companyInterName_NickName);
        companyInterNum = (TextView) findViewById(R.id.companyInterNum);
        companyInterMail = (TextView) findViewById(R.id.companyInterMail);
        suppression = (Button) findViewById(R.id.suppression);
        edit = (Button) findViewById(R.id.edit);
        specialisation = (Button) findViewById(R.id.specialisation);
        btnEntryAdd = (Button) findViewById(R.id.btnEntryAdd);


        goToMap = (Button) findViewById(R.id.goToMap);

        LightCompany imported = (LightCompany) intent.getSerializableExtra("lightCompany_exported");
        companyName.setText(Html.fromHtml("<b>Nom : "+imported.getName().toString()+"</b>"));
        companyAddress1.setText(Html.fromHtml("<b>Adresse 1 : "+imported.getAddress1().toString()+"</b>"));
        companyAddress2.setText(Html.fromHtml("<b>Complément : "+imported.getAddress2().toString()+"</b>"));
        companyPc.setText(Html.fromHtml("<b>Code postal : "+imported.getPc().toString()+"</b>"));
        companyCity.setText(Html.fromHtml("<b>Ville : "+imported.getCity().toString()+"</b>"));
        companyNum.setText(Html.fromHtml("<b> Téléphone secrétariat : "+imported.getNum().toString()+"</b>"));
        companyInterName_NickName.setText(Html.fromHtml("<b>Identité du représentant : "+imported.getInterNickName().toString()+" "+imported.getInterName().toString()+"</b>"));
        companyInterNum.setText(Html.fromHtml("<b>Numéro de téléphone du représentant : "+imported.getInterNum().toString()+"</b>"));
        companyInterMail.setText(Html.fromHtml("<b>Mail du représentant : "+imported.getInterMail().toString()+"</b>"));



        goToMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchTo_map(imported);
            }
        });

        suppression.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteCompany(imported.getStringId());
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editCompany(imported);
            }
        });

        specialisation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                specialisationManagement(imported);
            }
        });

        btnEntryAdd.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){ switchTo_Entry_add(imported);}
        });


    }



    public void switchTo_map(LightCompany uneCompany) {
        Intent intent = getIntent();
        String address = "geo:0,0?q= "+uneCompany.getAddress1()+", "+uneCompany.getCity()+", "+uneCompany.getPc();
        Uri gmmIntentUri = Uri.parse(address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void deleteCompany(String id) {
        Company uneCompany = new Company();
        String urle = uneCompany.urlGen("delete", String.valueOf(id));
        JSONObject res = uneCompany.getJsonFromURL(urle);
        Intent intent = new Intent(this, Company_vue.class);
        startActivity(intent);
    }

    public void switchTo_Entry_add(LightCompany exportedCompany){
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.entry.Entry_add.class);
        intent.putExtra("exportedCompany",exportedCompany);
        startActivity(intent);
    }

    public void editCompany(LightCompany uneCompany) {
        Intent intent = new Intent(getApplicationContext(), Company_edit.class);          // Pour sa on la loge dans une classe légère compatible avec le
        intent.putExtra("lightCompany_exported", uneCompany);                   // "serializable"
        startActivity(intent);
    }

    public void specialisationManagement(LightCompany uneCompany) {
        Intent intent = new Intent(this, Company_manage_specialisation.class);          // Pour sa on la loge dans une classe légère compatible avec le
        intent.putExtra("lightCompany_exported", uneCompany);                   // "serializable"
        startActivity(intent);
    }


}
