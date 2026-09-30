package fr.alban.dao;

/* Lecture de fichier */

import java.io.IOException;
import java.io.InputStream;
/* Gérer la liaison avec la BDD SQL */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* Librairie conçue pour travailler avec des dictionnaires clef / valeur */
import java.util.Properties;

import static java.lang.System.out;

/**
 * L'objectif de cette classe est si aucune exception n'est levée
 * de retourner le DriverManager.getConnection (URL, USER, PASSWORD).
 * Sinon de lever des exceptions
 * à la base de données.
 */
public class DataBaseConnexion {

    private DataBaseConnexion() throws DataBaseException{
        /* This utility class should not be instantiated */
    }

    // Paramètres de connexion centralisés
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    /* Code généré par IA le 23-09-2026 */
    // Bloc statique exécuté une seule fois lors du chargement de la classe
    static void  init() throws DataBaseException{
        Properties props = new Properties();

        try {
            /* Chargement du fichier depuis le classpath (src/main/resources/env.properties) */
            try (InputStream input = DataBaseConnexion.class.getClassLoader().getResourceAsStream("env.properties")) {
                if (input == null) {
                    throw new IllegalStateException("Fichier env.properties introuvable dans le classpath.");
                }
                props.load(input);

                URL = props.getProperty("db.url");
                USER = props.getProperty("db.user");
                PASSWORD = props.getProperty("db.password");
            } catch (IOException ioException) {
                throw new RuntimeException("Erreur de lecture du fichier env.properties", ioException);
            }

            /* tester la présence du driver JDBC */
            isDriverInstalled();

        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    static void isDriverInstalled() throws DataBaseException{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    static {
        try {
            init();
        } catch (DataBaseException ex) {
            out.println("Une exception s'est déclenchée ! \n le programme va s'arrêter !");
            ex.getCause().printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Ouvre et retourne une connexion JDBC.
     *
     * @return DriverManager.getConnection(URL, USER, PASSWORD);
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (URL == null || USER == null || PASSWORD == null) {
            throw new SQLException("Les identifiants de connexion n'ont pas été initialisés correctement.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
