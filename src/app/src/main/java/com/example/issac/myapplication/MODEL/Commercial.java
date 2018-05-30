package com.example.issac.myapplication.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Commercial extends Model {
    protected int id;
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

    public ArrayList<Commercial> JSONArrayToCommercials(ArrayList<JSONObject> table) {
        ArrayList<Commercial> lesCommercials = new ArrayList<Commercial>();
        int i;
        for(i=0;i<table.size();i++) {
            Commercial leCommercial = new Commercial();
            leCommercial.putInObj(table.get(i));
            lesCommercials.add(leCommercial);
        }
        return lesCommercials;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
