package com.example.issac.ppe2sanskt.IHM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.issac.ppe2sanskt.R;

/*
    Ce projet n'est qu'un brouillon et un rappel du fonctionnement des activités, pour jump d'une activité à l'autre.

    Créer une activité :
        Il faut un fichier class, un fichier xml et quelques lignes à ajouter dans main_activity et le manifest


        - créez un fichier dans res->layout-> [nom].xml | mettez y vos styles, boutons, etc...

        - créez un fichier de classe dans java->[votre dossier, ici j'ai pris par défaut]->[nom].class

        - créez quelques lignes dans manifest de manière à avoir au moins :

                        <activity android:name=".[nom]">
                        </activity>

        - créez quelques lignes dans votre main_activity :
                Un bouton : private Boutton [nom];
                Une liaison entre la variable et le bouton réel : [nom] = (Button) findViewById(R.id.[nom bouton]);

                Un truc qui se passe quand vous cliquez sur le bouton :
                            [nom].setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
                                    [fonction ou directos un truc du genre :
                                            startActivity(new Intent([activité actuelle].this, [nom].class));
                                    ]
                                }
                            });

 */

public class MainActivity extends AppCompatActivity {
    private Button exit;                                                // on déclare à l'avance tout les boutons ici dans l'activité
    private Button specialisation_vue;
    private Button user_add;
    private Button specialisation_add;
    private Button commercial_add;
    private Button company_vue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {                // lorsque que l'activité est lancée
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                         // le contenu affiché est celui du fichier "activity_main.xml"
        exit = (Button) findViewById(R.id.exit);                        // Le bouton exit est lié au bouton portant l'id "exit"
        specialisation_vue = (Button) findViewById(R.id.specialisation_vue);              // Le bouton user_view est lié au bouton portant l'id "user_view"
        user_add = (Button) findViewById(R.id.user_add);                // ... ^
        specialisation_add = (Button) findViewById(R.id.specialisation_add);        //
        commercial_add = (Button) findViewById(R.id.commercial_add);
        company_vue = (Button) findViewById(R.id.company_vue);




        exit.setOnClickListener(new OnClickListener() {                                        // quand on clique sur le bouton exit
                public void onClick(View v) {                           // fonction qui se déclenche quand on clique
                    finish();                                           // fin de l'app
                    System.exit(0);                              // android quitte l'application
                }
            });
        specialisation_vue.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton user_view
                    public void onClick(View v) {
                        switchTo_specialisation_vue();                           // la fonction switchTo va changer l'activité
                    }
                });

        user_add.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton user_add
            public void onClick(View v) {
                switchTo_user_add();                                   // la fonction switchTo va changer l'activité
            }
        });

        specialisation_add.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton main_options
            public void onClick(View v) {
                switchTo_specialisation_add();                                   // la fonction switchTo va changer l'activité
            }
        });

        commercial_add.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switchTo_commercial_add();
            }
        });

        company_vue.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switchTo_company_vue();
            }
        });



    }
/*
10/04
Matthieu
Procedure qui permet de changer d'activité, passe de l'activité courante à la liste des clients, l'ajout des clients, ou des options
activity (this) to (user_list)
*/
    public void switchTo_user_list() {
        Intent intent = new Intent(this, User_list.class);// le jump par d'ici pour aller sur user_list, par exemple
        startActivity(intent);                                          // on saute
    }
    public void switchTo_user_add() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.User_add.class);
        //Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.company_showcase.class);
        startActivity(intent);
    }

    public void switchTo_main_options() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.Main_options.class);
        startActivity(intent);
    }

    public void switchTo_specialisation_add() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.specialisation.specialisation_add.class);
        startActivity(intent);
    }

    public void switchTo_specialisation_vue() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.specialisation.Specialisation_vue.class);
        startActivity(intent);
    }

    public void switchTo_commercial_add() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.Commercial_add.class);
        startActivity(intent);
    }


    public void switchTo_company_vue() {
        Intent intent = new Intent(this, com.example.issac.ppe2sanskt.IHM.company.company_vue.class);
        startActivity(intent);
    }

}
