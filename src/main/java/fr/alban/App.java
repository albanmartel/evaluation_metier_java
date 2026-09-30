package fr.alban;

import static java.lang.System.*;

import fr.alban.dao.TestDBConnexion;
import fr.alban.models.TrainingCourse;

import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class App {

    /**
     * Méthode vestige de l'ancienne application "HelloWord
     *
     * @param args le tableau de String envoyé par le main
     */
    public static void helloWord(String[] args) {
        out.println("Hello World!");
    }

    /**
     * Méthode pour tester la connection à la base de données
     *
     * @throws SQLNonTransientConnectionException permet de lever une exception en rapport avec
     *                                            une connexion à la base de données impossible pour des variables d'environnement
     *                                            mal faites ou un serveur de base de données non démarré ou accessible
     */
    public static void testDataBaseConnection() throws SQLNonTransientConnectionException {

        try {
            TestDBConnexion testDBConnexion = new TestDBConnexion();
            out.println(testDBConnexion);
        } catch (Exception e) {
            throw new SQLNonTransientConnectionException("impossible de ce connecter à la base de données", e);
        } finally {
            out.println("Une exception s'est produite en rapport \n" +
                    "avec la connection à la Base de données\n" +
                    "Soit le env.properties contient des informations erronées \n" +
                    "Soit le serveur de Base de données est inaccessible ou pas démarré.");
        }
    }

    /**
     * Méthode pour tester la connexion à la base de données.
     * Elle capture l'exception SQLNonTransientConnectionException
     */
    public static void verifyDataBaseConnection() {
        out.println("Connect to database...");
        try {
            testDataBaseConnection();
        } catch (SQLNonTransientConnectionException e) {
            out.println(e.getMessage() + "\n" + e.fillInStackTrace());
        } finally {
            out.println("Une exception s'est produite en rapport \n" +
                    "avec la connection à la Base de données\n" +
                    "Soit le env.properties contient des informations erronées \n" +
                    "Soit le serveur de Base de données est inaccessible ou pas démarré.");
        }
    }

    public static void main(String[] args) {
        helloWord(args);
        verifyDataBaseConnection();
    }
}
