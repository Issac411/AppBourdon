package com.example.issac.ppe2sanskt.CONFIG;

public abstract class config {
    private static String url = "mattwork.fr"; // l'url qui sera utilisée pour faire le requêtage SQL, il faut que l'url en question puise gérer les demandes SQL

    public static String getUrl() {
        return url;
    }
}
