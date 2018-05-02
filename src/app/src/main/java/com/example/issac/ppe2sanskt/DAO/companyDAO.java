package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.company;


public class companyDAO extends DAO<company> {
private static final String TABLE_CLASSE = "company";
    private static final String COLD_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_ADDRESS1 = "address1";
    private static final String COL_ADDRESS2 = "address2";
    private static final String COL_NUM = "num";
    private static final String COL_FAX = "fax";
    private static final String COL_PC = "pc";
    private static final String COL_CITY = "city";
    private static final String COL_INTERNAME = "name";
    private static final String COL_INTERNICKNAME = "nickName";
    private static final String COL_INTERNUM = "num";
    private static final String COL_INTERFAX = "fax";




    public void drop(company lacompany) {

    }

    public company create(company lacompany) {
        return lacompany;
    }

    private String select(company lacompany) {

        return new String();
    }

    public company update(company lacompany) {
        return lacompany;
    }


}
