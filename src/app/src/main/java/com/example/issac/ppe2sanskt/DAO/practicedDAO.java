package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.practiced;


public class practicedDAO extends DAO<practiced> {
private static final String TABLE_CLASSE = "entry";
    private static final String COLD_ID = "id";
    private static final String COL_IDSpecialisation = "idSpecialiation";
    private static final String COL_IDCompany = "idCompany";



    public void drop(practiced lepracticed) {

    }

    public practiced create(practiced lepracticed) {
        return lepracticed;
    }

    private String select(practiced lepracticed) {

        return new String();
    }

    public practiced update(practiced lepracticed) {
        return lepracticed;
    }


}
