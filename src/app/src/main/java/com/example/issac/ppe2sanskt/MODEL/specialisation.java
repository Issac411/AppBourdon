package com.example.issac.ppe2sanskt.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

public class specialisation extends model
{
    private String libelle;
    private String code;

    public specialisation() {
        super("specialisation");
        this.libelle = null;
        this.code = null;
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
}
