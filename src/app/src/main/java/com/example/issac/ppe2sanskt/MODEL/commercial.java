package com.example.issac.ppe2sanskt.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

public class Commercial extends Model {
    private String name;
    private String nickName;
    private String address1;
    private String address2;
    private String pc;
    private String city;

    public Commercial() {
        super("commercial");            // on déclare le nom de la table
    }

    /*
    07/05
    Matthieu (basé sur Boutte)
    Permet d'assigner des attributs d'un objet avec un élément JSON
     */

    public void putInObj(JSONObject json) {
        try {
            this.name = json.getString("name");                 // ici on assigne la totalité des attributs avec le résultat en JSON
            this.nickName = json.getString("nickName");
            this.address1 = json.getString("address1");
            this.address2 = json.getString("address2");
            this.pc = json.getString("pc");
            this.city = json.getString("city");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
