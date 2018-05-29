package com.example.issac.myapplication.IHM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.R;

import java.io.IOException;

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

