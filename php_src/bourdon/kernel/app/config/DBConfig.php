<?php
class DBConfig{
    public static $base = "confname";       // le nom de la config utilisée
    public static $conf = array(
        "confname" => array(
            "eng" => "pgsql",
            "host" => "localhost",
            "dbname" => "postgres",
            "user" => "postgres",
            "password" => "postgres"
        )

    );
}
?>