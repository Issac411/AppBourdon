package com.example.issac.myapplication.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Practiced extends Model
{
    protected int id;
    private int idSpecialisation;
    private int idCompany;


    public Practiced() {
        super("practiced");
    }

    @Override
    protected void putInObj(JSONObject json) {
        try {
            this.idSpecialisation = json.getInt("idspecialisation");
            this.idCompany = json.getInt("idcompany"); // ici on assigne la totalité des attributs avec le résultat en JSON (ici modif pour debug req Creation)
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getIdSpecialisation() {
        return idSpecialisation;
    }

    public void setIdSpecialisation(int idSpecialisation) {
        this.idSpecialisation = idSpecialisation;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public ArrayList<Practiced> JSONArrayToLink(ArrayList<JSONObject> table) {
        ArrayList<Practiced> lesPracticed = new ArrayList<Practiced>();
        int i;
        for(i=0;i<table.size();i++) {
            Practiced Practiced = new Practiced();
            Practiced.putInObj(table.get(i));
            lesPracticed.add(Practiced);
        }
        return lesPracticed;
    }
}
