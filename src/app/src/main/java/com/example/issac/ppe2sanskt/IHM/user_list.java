package com.example.issac.ppe2sanskt.IHM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
        user_list va lister les clients du commercial, il va donc falloir faire des requêtes avec la base de données.
        Pour faire ces requêtes, la solution la plus claire est de faire des échanges JSON avec un serveur web (Java -> PHP -> BDD)
        Il existe deux librairies pour solutionner notre problèmatique :
                - Volley
                - OkHttp3

        J'ai choisis OkHttp3 car c'est le plus simple à mettre en place, pas le temps de naiser.

        Ici, j'ai juste fait un test, la page php pointée est une sorte de ruine que j'ai rapidement monter qui donne juste les administrateurs d'une BDD au pif de mon serveur.
        L'important, c'est de recevoir de la donnée.

        Dans un premier temps, il faut aller dans le manifest et ajouter les permissions d'accès réseau SINON L APP VA CRASH (expérience personnelle) :
            <uses-permission android:name="android.permission.INTERNET" />
            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

        On oublie évidement pas de rajouter le bon bloc dans le user_list xml, c'est à dire un textView avec l'id "text_view_result"

        Egalement, on pense a bien éditer le build.gradle dans gradle Scripts pour ajouter ça :

            implementation 'com.squareup.okhttp3:okhttp:3.4.1'

        Ensuite, le code n'est pas originalement de moi, j'ai repris le contenu de Coding in Flow
        source : https://youtu.be/oGWJ8xD2W6k
        source 2 : https://codinginflow.com/code-examples/android/okhttp-simple-http-request
 */


// stratégie 1 : URL avec tous les paramètres, gestion en PHP des solutions de connexion BDD



public class User_list extends AppCompatActivity {

    private TextView mTextViewResult;   // c'est là dedans qu'il y aura notre reception

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        mTextViewResult = findViewById(R.id.text_view_result);      // la variable est liée au texte graphique

        OkHttpClient client = new OkHttpClient();           // intanciation du client

        String url = "http://mattwork.fr/application.php?group=utilisateur&id=N&element=prenom";  // le site sur lequel on va récupérer nos données -> [D'ailleurs, je pense que pour avoir des données spécifiques (genre un user avec tel ID
        //    on pourrait juste rajouter un $_GET genre "...?ID=2"

        Request request = new Request.Builder()     // On créer la requête, on remarque que dans url, il faut mettre bah... l'url
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {            // ici, on tente de faire cette action, c'est à dire d'envoyer la requête avec newCall
            @Override
            public void onFailure(Call call, IOException e) {       // si sa marche pas, on a le sum
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {       // Si sa fonctionne par contre...
                if (response.isSuccessful()) {                                                                          // quu'on a bien réussi à avoir une réponse lisible
                    final String Response = response.body().string();             // on récupère dans le corps de la réponse le texte

                    User_list.this.runOnUiThread(new Runnable() {       // Ce lance en background
                        // déjà existant dans user_list, bien que mettre autre chose que l'activité courante ne fonctionne pas.
                        @Override
                        public void run() {
                            mTextViewResult.setText(Response);        // assignation du texte
                        }
                    });
                }
            }
        });
    } }