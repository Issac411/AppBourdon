package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.importance;


public class importanceDAO extends DAO<importance> {
private static final String TABLE_CLASSE = "importance";
    private static final String COLD_ID = "id";
    private static final String COL_CONTENT = "libelle";




    public void drop(importance lacompany) {

    }

    public importance create(importance limportance) {
        return limportance;
    }

    private String select(importance limportance) {

        return new String();
    }

    public importance update(importance limportance) {
        return limportance;
    }


}
