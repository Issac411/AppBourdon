package com.example.issac.myapplication.MODEL;
import com.example.issac.myapplication.CONFIG.Config;
import com.example.issac.myapplication.CONFIG.HttpClient;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public abstract class Model extends Config
{
    private String table;
    private String sqlRes;

    public void setTable(String table) {
        this.table = table;
    }

    public String getSqlRes() {
        return sqlRes;
    }

    public void setSqlRes(String sqlRes) {
        this.sqlRes = sqlRes;
    }

    public Model(String latable) {
        table = latable;                       // tout le monde a une table et un id en bdd
    }

    public String getTable() {
        return this.table;
    }
    // mise en place du système CRUD

        protected boolean read(int id) {
        JSONObject json; // les données PHP seront encodés en JSON, du coup, on se prépare à le recevoir dans une variable du genre
        boolean res = false;
        /*json = getJsonFromURL(config.getUrl()+this.table+"/read/"+ id);     // on build l'url, on prend le début dans config, puis le nom variable de la table (trouvé des enfants) + l'id recherché
            if(json != null) {
                this.putInObj(json);        // on loge le résultat dans une fonction qui sera abstraite dans model, elle variera selon l'objet (on peut pas, comme en PHP, remplir un tableeau en fonction
                res = true;                // d'un nombre inconnu d'élements donc on prépare tout d'avance)
            } else {
                res = false;
            }*/
            return res;
        }

        // pour communiquer avec la base de donnée, on doit utiliser httpclient ou okhttpclient


    /*
    07/05
    Boutte
    On constitue une requête via l'url et on l'exécute pour obtenir le résultat en JSON
     */
    public JSONObject getJsonFromURL(String url ){
        JSONObject res = new JSONObject();
        try {
            res = new JSONObject(new HttpClient().execute(url).get());
            return res;
        }catch (Throwable e){
            return new JSONObject();
        }
    }

    /*
        07/05
        Matthieu (basé sur Boutte)
        Permet d'assigner des attributs d'un objet avec un élément JSON
         */
    protected abstract void putInObj(JSONObject json);      // pour loger dans l'objet selon les attributs de ce dernier.



    /*
    07/05
    Matthieu
    On forme une URL, magnifique
    On fait entrer site&dossier+controllerDatabase+fonction(table)+act+param[tab]
     */
    public String urlGen(String action, String... params ) {
        int i;
        String url = "http://"+Config.getUrl()+"Database/"+this.table+"/"+action;
        for(i = 0;i < params.length;i++) {
            url = url+"/"+params[i];

        }
        return url;

    }

    public static Object toJSON(Object object) throws JSONException {
        if (object instanceof Map) {
            JSONObject json = new JSONObject();
            Map map = (Map) object;
            for (Object key : map.keySet()) {
                json.put(key.toString(), toJSON(map.get(key)));
            }
            return json;
        } else if (object instanceof Iterable) {
            JSONArray json = new JSONArray();
            for (Object value : ((Iterable)object)) {
                json.put(value);
            }
            return json;
        } else {
            return object;
        }
    }

    public static boolean isEmptyObject(JSONObject object) {
        return object.names() == null;
    }

    public static Map<String, Object> getMap(JSONObject object, String key) throws JSONException {
        return toMap(object.getJSONObject(key));
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, fromJson(object.get(key)));
        }
        return map;
    }

    public static List toList(JSONArray array) throws JSONException {
        List list = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            list.add(fromJson(array.get(i)));
        }
        return list;
    }

    private static Object fromJson(Object json) throws JSONException {
        if (json == JSONObject.NULL) {
            return null;
        } else if (json instanceof JSONObject) {
            return toMap((JSONObject) json);
        } else if (json instanceof JSONArray) {
            return toList((JSONArray) json);
        } else {
            return json;
        }
    }

    /* Matthieu
    24/05/18
    retourne un JSONOArray
    Avec l'objet JSON passé en param, retourne le tableau qu'il contient si il en existe un sous le nom de "res"
    */
        public JSONArray getAllObject(JSONObject object) {
            ArrayList<String> jsonArray = new ArrayList<String>();
            JSONArray element;
            try {
                element = object.getJSONArray("res");
            } catch (JSONException e) {
                element = new JSONArray();
                e.printStackTrace();
            }
            return element;
        }


}
