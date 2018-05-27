package com.example.issac.ppe2sanskt.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

public class Entry extends Model
{
    protected String date;
    protected String comment;
    protected String duration;
    protected String status;

    public Entry() {
        super("entry");
        date = null;
        comment = null;
        duration = null;
        status = null;
    }

    @Override
    protected void putInObj(JSONObject json) {
        try {
            date = json.getString("date");
            comment = json.getString("comment");
            duration = json.getString("duration");
            status = json.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
