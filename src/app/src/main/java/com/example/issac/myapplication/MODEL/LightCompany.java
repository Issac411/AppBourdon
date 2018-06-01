package com.example.issac.myapplication.MODEL;

import java.io.Serializable;

public class LightCompany  implements Serializable {
<<<<<<< HEAD
    private int id;
=======
    protected int id;
>>>>>>> 0c673d587278efd352d5772bbfd6a89b1a8a8785
    private String name;        // le texte que l'utilisateur compléte
    private String address1;
    private String address2;
    private String pc;
    private String num;
    private String fax;
    private String interName;
    private String interNickName;
    private String interNum;
    private String interFax;
    private String mail;
    private String interMail;
    private String city;

    public LightCompany(Company uneCompany) {
        this.id = uneCompany.getId();
        this.name = uneCompany.getName();
        this.address1 = uneCompany.getAddress1();
        this.address2 = uneCompany.getAddress2();
        this.pc = uneCompany.getPc();
        this.num = uneCompany.getNum();
        this.fax = uneCompany.getFax();
        this.interName = uneCompany.getInterName();
        this.interNickName = uneCompany.getInterNickName();
        this.interNum = uneCompany.getInterNum();
        this.interFax = uneCompany.getInterFax();
        this.mail = uneCompany.getMail();
        this.interMail = uneCompany.getInterMail();
        this.city = uneCompany.getCity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getInterNickName() {
        return interNickName;
    }

    public void setInterNickName(String interNickName) {
        this.interNickName = interNickName;
    }

    public String getInterNum() {
        return interNum;
    }

    public void setInterNum(String interNum) {
        this.interNum = interNum;
    }

    public String getInterFax() {
        return interFax;
    }

    public void setInterFax(String interFax) {
        this.interFax = interFax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getInterMail() {
        return interMail;
    }

    public void setInterMail(String interMail) {
        this.interMail = interMail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
