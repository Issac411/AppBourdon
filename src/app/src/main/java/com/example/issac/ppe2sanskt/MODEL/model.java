package com.example.issac.ppe2sanskt.MODEL;
import com.example.issac.ppe2sanskt.CONFIG.config;
import com.example.issac.ppe2sanskt.CONFIG.HttpClient;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public abstract class model extends config
{
    private String table;
    private int id;



    public model(String latable) {
        table = latable;                       // tout le monde a une table et un id en bdd
    }
    // mise en place du système CRUD

        protected boolean read(int id) {
        JSONObject json; // les données PHP seront encodés en JSON, du coup, on se prépare à le recevoir dans une variable du genre
        boolean res;
        json = getJsonFromURL(config.getUrl()+this.table+"/read/"+ id);     // on build l'url, on prend le début dans config, puis le nom variable de la table (trouvé des enfants) + l'id recherché
            if(json != null) {
                this.putInObj(json);        // on loge le résultat dans une fonction qui sera abstraite dans model, elle variera selon l'objet (on peut pas, comme en PHP, remplir un tableeau en fonction
                res = true;                // d'un nombre inconnu d'élements donc on prépare tout d'avance)
            } else {
                res = false;
            }
            return res;
        }

        // pour communiquer avec la base de donnée, on doit utiliser httpclient ou okhttpclient

    /*
    07/05
    Matthieu
    On constitue une requête via l'url et on l'exécute pour obtenir le résultat en JSON
     */
        protected JSONObject getJsonFromURL2(String leurl) {
            JSONObject json = new JSONObject();
            try {
                OkHttpClient client = new OkHttpClient();           // intanciation du client
                Request request = new Request.Builder().url(leurl).build(); // On créer la requête, on remarque que dans url, il faut mettre bah... l'url
                client.newCall(request).enqueue(new Callback() {            // ici, on tente de faire cette action, c'est à dire d'envoyer la requête avec newCall
                    @Override
                    public void onFailure(Call call, IOException e) {       // si sa marche pas, on a le sum
                        e.printStackTrace();
                    }
                    public void onResponse(Call call, Response response) throws IOException {       // Si sa fonctionne par contre...
                        if (response.isSuccessful()) {                                                                          // quu'on a bien réussi à avoir une réponse lisible
                            final String result = response.body().string();             // on récupère dans le corps de la réponse le texte
                            try {
                                final JSONObject json = new JSONObject(result);     // on déclare un objet en Json avec le resultat
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch(Throwable e) {
                }
            return json;
        }
    /*
    07/05
    Boutte
    On constitue une requête via l'url et on l'exécute pour obtenir le résultat en JSON
     */
    protected JSONObject getJsonFromURL(String url){
        JSONObject res;
        try {

            res = new JSONObject(new HttpClient().execute(url).get());
        }catch (Throwable e){
            res = null;
        }
        return res;
    }

    /*
    07/05
    Matthieu (basé sur Boutte)
    Permet d'assigner des attributs d'un objet avec un élément JSON
     */
    protected abstract void putInObj(JSONObject json);      // pour loger dans l'objet selon les attributs de ce dernier.

    public int getId() {
        return this.id;
    }



    /*
    07/05
    Matthieu
    On forme une URL, magnifique
    On fait entrer site&dossier+controllerDatabase+fonction(table)+act+param[tab]
     */
    protected void urlGen(String action, String... params ) {
        String url = config.getUrl()+"Database/"+this.table+"/"+action;

    }


}
