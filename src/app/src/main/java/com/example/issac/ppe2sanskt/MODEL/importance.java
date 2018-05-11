package com.example.issac.ppe2sanskt.MODEL;


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
    protected void putInObj(JSONObject json) {

    }


}
