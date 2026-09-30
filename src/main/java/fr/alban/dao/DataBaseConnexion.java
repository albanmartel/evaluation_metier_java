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

/**
 * L'objectif de cette classe est si aucune exception n'est levée
 * de retourner le DriverManager.getConnection (URL, USER, PASSWORD).
 * Sinon de lever des exceptions
 * à la base de données.
 */
public class DataBaseConnexion {

    private DataBaseConnexion() {
        /* This utility class should not be instantiated */
    }

    // Paramètres de connexion centralisés
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    /* Code généré par IA le 23-09-2026 */
    // Bloc statique exécuté une seule fois lors du chargement de la classe
    static void init() throws DataBaseException {
        try {
            /* tester le chargement du fichier des variables d'environnement */
            loadEnvironnementVariables();
            /* tester la présence du driver JDBC */
            isDriverInstalled();

        } catch (Exception e) {
            throw new DataBaseException(e.getMessage(),e);
        }
    }

    static void loadEnvironnementVariables() throws DataBaseException {
        Properties props = new Properties();

        try (InputStream input = DataBaseConnexion.class.getClassLoader().getResourceAsStream("env.properties")) {
            if (input == null) {
                throw new IllegalStateException("Fichier env.properties introuvable dans le classpath.");
            }
            props.load(input);

            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");
        } catch (IOException ioException) {
            throw new DataBaseException("Erreur de lecture du fichier env.properties", ioException);
        }
    }

    static void isDriverInstalled() throws DataBaseException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            throw new DataBaseException("une exception est survenue", classNotFoundException);
        }
    }

    static {
        try {
            init();
        } catch (DataBaseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ouvre et retourne une connexion JDBC.
     *
     * @return DriverManager.getConnection(URL, USER, PASSWORD);
     * @throws SQLException exception sql de connection à la base
     */
    public static Connection getConnection() throws SQLException {
        if (URL == null || USER == null || PASSWORD == null) {
            throw new SQLException("Les identifiants de connexion n'ont pas été initialisés correctement.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
