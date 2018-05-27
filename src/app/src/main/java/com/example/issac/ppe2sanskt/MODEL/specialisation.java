package com.example.issac.ppe2sanskt.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class specialisation extends model implements Serializable
{
    private String libelle;
    private String code;

    public specialisation() {
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
    public ArrayList<specialisation> JSONArrayToSpecialisations(ArrayList<JSONObject> table) {
        ArrayList<specialisation> lesSpecialisations = new ArrayList<specialisation>();
        int i;
        for(i=0;i<table.size();i++) {
            specialisation laSpecialisation = new specialisation();
            laSpecialisation.putInObj(table.get(i));
            lesSpecialisations.add(laSpecialisation);
        }
        return lesSpecialisations;
    }

}
