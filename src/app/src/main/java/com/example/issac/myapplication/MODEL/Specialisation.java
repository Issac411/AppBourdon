package com.example.issac.myapplication.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Specialisation extends Model implements Serializable
{
    protected int id;
    private String libelle;
    private String code;

    public Specialisation() {
        super("specialisation");
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void putInObj(JSONObject json) {
        try {
            this.code = json.getString("code");                 // ici on assigne la totalité des attributs avec le résultat en JSON (ici modif pour debug req Creation)
            this.libelle = json.getString("libelle");
            this.id = json.getInt("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* Matthieu
    24/05/18
    Retourne un tableau contenant des objets specialisation
    Permet de convertir un tableau contenant des objets JSON en specialisations
     */
    public ArrayList<Specialisation> JSONArrayToSpecialisations(ArrayList<JSONObject> table) {
        ArrayList<Specialisation> lesSpecialisations = new ArrayList<Specialisation>();
        int i;
        for(i=0;i<table.size();i++) {
            Specialisation laSpecialisation = new Specialisation();
            laSpecialisation.putInObj(table.get(i));
            lesSpecialisations.add(laSpecialisation);
        }
        return lesSpecialisations;
    }

}
