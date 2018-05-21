package com.example.issac.ppe2sanskt.MODEL;


import org.json.JSONException;
import org.json.JSONObject;

public class importance extends model
{
    private String content;

    public importance() {
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


    public String getContent() {
        return content;
    }


}
