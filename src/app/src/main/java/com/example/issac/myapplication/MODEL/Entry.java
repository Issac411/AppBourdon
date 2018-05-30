package com.example.issac.myapplication.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Entry extends Model
{
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

    @Override
    protected void putInObj(JSONObject json) {
        try{

            this.idcompany = json.getInt("idcompany");
            this.idcommercial = json.getInt("idcommercial");
            this.idimportance = json.getInt("idimportance");
            this.date = convertStringToTimestamp(json.getString("date")); //NON testé
            this.comment = json.getString("comment");
            this.duration = json.getInt("durantion");
            this.status = json.getString("status");
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Timestamp convertStringToTimestamp(String str_date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = (Date) dateFormat.parse(str_date);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        } catch(Exception e) {
            return null;
        }
    }

    public String create(){
        JSONObject res = new JSONObject();
        String url = this.urlGen("create",
                String.valueOf(6),
                String.valueOf(1),
                String.valueOf(1),
                String.valueOf(this.date),
                this.comment,
                String.valueOf(this.duration),
                this.status
                // on prépare l'url pour la requête en fonction de l'action voulue + champ// écrit
        );
        res = this.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
        return url;
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
