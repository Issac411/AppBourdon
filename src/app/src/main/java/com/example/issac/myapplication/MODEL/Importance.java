package com.example.issac.myapplication.MODEL;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Importance extends Model
{
    protected int id;
    private String content;

    public Importance() {
        super("importance");
        this.content = null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    /*
    07/05
    Matthieu (basé sur Boutte)
    Permet d'assigner des attributs d'un objet avec un élément JSON
     */ public void putInObj(JSONObject json) {
        try {
            this.content = json.getString("res");                 // ici on assigne la totalité des attributs avec le résultat en JSON (ici modif pour debug req Creation)
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Importance> JSONArrayToImportances(ArrayList<JSONObject> table) {
        ArrayList<Importance> lesImportances = new ArrayList<Importance>();
        int i;
        for(i=0;i<table.size();i++) {
            Importance lImportance = new Importance();
            lImportance.putInObj(table.get(i));
            lesImportances.add(lImportance);
        }
        return lesImportances;
    }

    public String getContent() {
        return content;
    }


}
