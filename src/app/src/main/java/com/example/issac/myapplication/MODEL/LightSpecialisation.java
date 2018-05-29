package com.example.issac.myapplication.MODEL;

import java.io.Serializable;

public class LightSpecialisation implements Serializable {
    private String libelle;
    private String code;
    private int id;

    public LightSpecialisation(Specialisation uneSpecialisation) {
        this.libelle = uneSpecialisation.getLibelle();
        this.code = uneSpecialisation.getCode();
        this.id = uneSpecialisation.getId();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


