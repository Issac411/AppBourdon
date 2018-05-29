package com.example.issac.ppe2sanskt.CONFIG;

public abstract class Config {
    private static String url = "mattwork.fr/bourdon/"; // l'url qui sera utilisée pour faire le requêtage SQL, il faut que l'url en question puise gérer les demandes SQL

    public static String getUrl() {
        return url;
    }
}
