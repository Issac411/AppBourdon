package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.commercial;


public class commercialDAO extends DAO<commercial> {
    private static final String TABLE_CLASSE = "commercial";
    private static final String COLD_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_NICKNAME = "nickName";
    private static final String COL_ADDRESS1 = "address1";
    private static final String COL_ADDRESS2 = "address2";
    private static final String COL_PC = "pc";
    private static final String COL_CITY = "city";

    public void drop(commercial leclient) {

    }

    public commercial create(commercial lecommercial) {
        return lecommercial;
    }

    private String select(commercial lecommercial) {

        return new String();
    }

    public commercial update(commercial lecommercial) {
        return lecommercial;
    }


}
