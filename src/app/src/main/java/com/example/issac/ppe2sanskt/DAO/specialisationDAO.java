package com.example.issac.ppe2sanskt.DAO;
import com.example.issac.ppe2sanskt.MODEL.specialisation;


public class specialisationDAO extends DAO<specialisation> {
private static final String TABLE_CLASSE = "specialisation";
    private static final String COLD_ID = "id";
    private static final String COL_LIBELLE = "libelle";
    private static final String COL_CODE = "code";




    public void drop(specialisation laspecialisation) {

    }

    public specialisation create(specialisation laspecialisation) {
        return laspecialisation;
    }

    private String select(specialisation laspecialisation) {

        return new String();
    }

    public specialisation update(specialisation laspecialisation) {
        return laspecialisation;
    }


}
