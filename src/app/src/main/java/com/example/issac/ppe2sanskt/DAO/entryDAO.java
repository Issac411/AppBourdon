package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.entry;


public class entryDAO extends DAO<entry> {
private static final String TABLE_CLASSE = "entry";
    private static final String COLD_ID = "id";
    private static final String COL_DATE = "date";
    private static final String COL_COMMENT = "comment";
    private static final String COL_DURATION = "duration";
    private static final String COL_STATUS = "status";



    public void drop(entry laspecialisation) {

    }

    public entry create(entry leentry) {
        return leentry;
    }

    private String select(entry leentry) {

        return new String();
    }

    public entry update(entry leentry) {
        return leentry;
    }


}
