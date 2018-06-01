package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.issac.myapplication.CONFIG.JSONAct;
import com.example.issac.myapplication.IHM.specialisation.Specialisation_add;
import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.myapplication.MODEL.LightCompany;
import com.example.issac.myapplication.MODEL.Practiced;
import com.example.issac.myapplication.MODEL.Specialisation;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


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
    private TextView specialisations;
    private Button specialisationDelete;
    JSONObject specialisation_JSON = new JSONObject();
    JSONArray specialisation_JSONArray = new JSONArray();
    ArrayList<JSONObject> specialisations_JSON_array = new ArrayList<JSONObject>();
    ArrayList<Specialisation> lesSpecialistions = new ArrayList<Specialisation>();
    ArrayList<String> lesIdSpecialisations = new ArrayList<String>();
    Specialisation uneSpecialisation = new Specialisation();

    JSONObject pratique_JSON = new JSONObject();
    JSONArray pratique_JSONArray = new JSONArray();
    ArrayList<JSONObject> pratiques_JSON_array = new ArrayList<JSONObject>();
    ArrayList<Practiced> lesPratiques = new ArrayList<Practiced>();
    ArrayList<Practiced> LesPratiquesDeLentreprise = new ArrayList<Practiced>();
    Practiced unePracticed = new Practiced();
    String chaine = "";



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
        specialisations = (TextView) findViewById(R.id.specialisations);
        specialisationDelete = (Button) findViewById(R.id.specialisationDelete);


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


        String url = uneSpecialisation.urlGen("read");
        JSONObject res = uneSpecialisation.getJsonFromURL(url);
        specialisation_JSON = uneSpecialisation.getJsonFromURL(url);                                            //
        specialisation_JSONArray = uneSpecialisation.getAllObject(specialisation_JSON);                         //
        specialisations_JSON_array = JSONAct.JSONArrayToArray(specialisation_JSONArray);                        //
        lesSpecialistions = uneSpecialisation.JSONArrayToSpecialisations(specialisations_JSON_array);           // <- JSONObject[JSONArray(JSONobj1)(JSONobj2)...]] TO -> ArrayList[(obj1)(obj2)...]


        url = unePracticed.urlGen("read");
        JSONObject res2 = unePracticed.getJsonFromURL(url);
        specialisation_JSON = unePracticed.getJsonFromURL(url);                                            //
        specialisation_JSONArray = unePracticed.getAllObject(specialisation_JSON);                         //
        specialisations_JSON_array = JSONAct.JSONArrayToArray(specialisation_JSONArray);                        //
        lesPratiques = unePracticed.JSONArrayToLink(specialisations_JSON_array);           // <- JSONObject[JSONArray(JSONobj1)(JSONobj2)...]] TO -> ArrayList[(obj1)(obj2)...]
        for(int i=0;i<lesPratiques.size();i++) {

            if(lesPratiques.get(i).getIdCompany() == imported.getId()) {
                for(int i2 = 0;i2<lesSpecialistions.size();i2++) {
                    if(lesSpecialistions.get(i2).getId() == lesPratiques.get(i).getIdSpecialisation()) {
                        chaine = chaine + " : " +lesSpecialistions.get(i2).getLibelle();
                        LesPratiquesDeLentreprise.add(lesPratiques.get(i));
                    }
                }

            }
        }
        if(chaine == "") {
            specialisations.setText(Html.fromHtml("<b>Aucune activité définie</b>"));
        } else {
            specialisations.setText(Html.fromHtml("<b>Secteur d'activité :</b>" + chaine));
        }

        goToMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchTo_map(imported);
            }
        });

        suppression.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteCompany(imported.getId());
                deleteCompany(Integer.parseInt(String.valueOf(imported.getId())));
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

        specialisationDelete.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){ specialisationDelete(imported);}
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

    public void deleteCompany(int id) {
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

    public void specialisationDelete(LightCompany imported) {
        int i;
        String url ="";
        for(i=0;i<lesPratiques.size();i++) {
            url = unePracticed.urlGen("delete",String.valueOf(lesPratiques.get(i).getIdSpecialisation()),String.valueOf(lesPratiques.get(i).getIdCompany()));
            unePracticed.getJsonFromURL(url);
        }
        specialisations.setText(url);
        Intent intent = new Intent(this, Company_details.class);          // Pour sa on la loge dans une classe légère compatible avec le
        intent.putExtra("lightCompany_exported", imported);                   // "serializable"
        startActivity(intent);
    }


}
