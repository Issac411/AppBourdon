package com.example.issac.myapplication.MODEL;

import android.provider.ContactsContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Entry extends Model
{
    protected int id;
    private int idcompany;
    private int idcommercial;
    private int idimportance;
    private Timestamp date;
    private String comment;
    private int duration;
    private String status;


    public Entry(){
        super("entry");
    }

    public Entry(LightEntry uneEntry){
        super("entry");
        id = uneEntry.getId();
        idcompany = uneEntry.getIdcompany();
        idcommercial = uneEntry.getIdcommercial();
        idimportance = uneEntry.getIdimportance();
        date = uneEntry.getDate();
        comment = uneEntry.getComment();
        duration = uneEntry.getDuration();
        status = uneEntry.getStatus();
    }





    @Override
    protected void putInObj(JSONObject json) {
        try{
            this.id =json.getInt("id");
            this.idcompany = json.getInt("idcompany");
            this.idcommercial = json.getInt("idcommercial");
            this.idimportance = json.getInt("idimportance");
            this.date = convertStringToTimestamp(json.getString("date")); //NON testé
            this.comment = json.getString("comment");
            this.duration = json.getInt("duration");
            this.status = json.getString("status");
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Entry> JSONArrayToEntry(ArrayList<JSONObject> table) {
        ArrayList<Entry> lesEntry = new ArrayList<>();
        int i;
        for(i=0;i<table.size();i++) {
            Entry uneEntry = new Entry();
            uneEntry.putInObj(table.get(i));
            lesEntry.add(uneEntry);
        }
        return lesEntry;
    }

    public Timestamp convertStringToTimestamp(String str_date) {
        try {
            Timestamp timestamp = Timestamp.valueOf(str_date);
            return  timestamp;
        } catch(Exception e) {
            return null;
        }
    }

    public String create(){
        JSONObject res = new JSONObject();
        String url = this.urlGen("create",
                String.valueOf(this.idcompany),
                String.valueOf(this.idcommercial),
                String.valueOf(this.idimportance),
                String.valueOf(this.date),
                this.comment,
                String.valueOf(this.duration),
                this.status
                // on prépare l'url pour la requête en fonction de l'action voulue + champ// écrit
        );
        res = this.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
        return url;
    }

    public String ChangerStatus(String status){
        this.status = status;
        JSONObject res = new JSONObject();
        String url = this.urlGen("update",
                String.valueOf(this.id),
                String.valueOf(this.idcompany),
                String.valueOf(this.idcommercial),
                String.valueOf(this.idimportance),
                String.valueOf(this.date),
                this.comment,
                String.valueOf(this.duration),
                this.status
                // on prépare l'url pour la requête en fonction de l'action voulue + champ// écrit
        );
        res = this.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
        return url;
    }


    public Company getCompany(){
        Company uneCompany = new Company();
        JSONObject res = new JSONObject();
        String url = uneCompany.urlGen("read",String.valueOf(this.idcompany));
        res = uneCompany.getJsonFromURL(url);
        uneCompany.putInObj(res);
        return uneCompany;
    }

    public Commercial getCommercial(){
        Commercial unCommercial = new Commercial();
        JSONObject res = new JSONObject();
        String url = unCommercial.urlGen("read",String.valueOf(this.idcommercial));
        res = unCommercial.getJsonFromURL(url);
        unCommercial.putInObj(res);
        return unCommercial;
    }

    public Importance getImportance(){
        Importance uneImportance = new Importance();
        JSONObject res = new JSONObject();
        String url = uneImportance.urlGen("read",String.valueOf(this.idimportance));
        res = uneImportance.getJsonFromURL(url);
        uneImportance.putInObj(res);
        return uneImportance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    public int getIdcommercial() {
        return idcommercial;
    }

    public void setIdcommercial(int idcommercial) {
        this.idcommercial = idcommercial;
    }

    public int getIdimportance() {
        return idimportance;
    }

    public void setIdimportance(int idimportance) {
        this.idimportance = idimportance;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
