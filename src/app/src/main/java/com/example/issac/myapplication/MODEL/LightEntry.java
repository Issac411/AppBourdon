package com.example.issac.myapplication.MODEL;


import java.io.Serializable;
import java.sql.Timestamp;

public class LightEntry implements Serializable{
    private int id;
    private int idcompany;
    private int idcommercial;
    private int idimportance;
    private Timestamp date;
    private String comment;
    private int duration;
    private String status;

    public LightEntry(Entry uneEntry){
        id = uneEntry.getId();
        idcompany = uneEntry.getIdcompany();
        idcommercial = uneEntry.getIdcommercial();
        idimportance = uneEntry.getIdimportance();
        date = uneEntry.getDate();
        comment = uneEntry.getComment();
        duration = uneEntry.getDuration();
        status = uneEntry.getStatus();

    }

    public String ToString(){
        String entry;
        entry = "idcompany : "+this.idcompany+
                "\nidcommercial : "+this.idcommercial+
                "\nidimportance : "+this.idimportance+
                "\ndate : "+String.valueOf(this.date)+
                "\ncomment : "+this.comment+
                "\nduration : "+this.duration+
                "\nstatus : "+this.status;

        return entry;
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
