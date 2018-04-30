package DAO;

import MODEL.client;

public class clientDAO extends DAO<client> {
    private static final String TABLE_CLASSE = "client";
    private static final String COLD_ID = "id";
    private static final String COL_NOM = "nom";
    private static final String COL_ADRESSE = "adresse";
    private static final String COL_COMMENTAIRE = "commentaire";
    private static final String COL_DATE_DV = "date_derniere_visite";
    private static final String COL_DUREE_DV = "duree_derniere_visite";

    public void drop(client leclient) {

    }

    public client create(client leclient) {
        return leclient;
    }

    private String select(client leclient) {

        return new String();
    }

    public client update(client leclient) {
        return leclient;
    }


}
