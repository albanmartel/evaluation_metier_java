package fr.alban;

import static java.lang.System.*;

import fr.alban.dao.DataBaseConnexion;
import fr.alban.dao.DataBaseException;
import fr.alban.dao.TestDBConnexion;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.TrainingCourse;

import java.sql.SQLException;


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
     * @throws Exception permet de lever une exception en rapport avec
     *                                            une connexion à la base de données impossible pour des variables d'environnement
     *                                            mal faites ou un serveur de base de données non démarré ou accessible
     */
    public static void testDataBaseConnection() throws DataBaseException {

        try {
            TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
            if (trainingCourseDao.isAccessible()){
                out.println("Connexion à la base de données réussie !");
            } else {
                out.println("Connexion à la base de données impossible !");
            }
        } catch (DataBaseException e) {
            throw new DataBaseException("impossible de ce connecter à la base de données", e);
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
        } catch (DataBaseException e) {
            out.println(e.getMessage() + "\n" + e.getExceptionMessage());
        }
    }

    public static void main(String[] args) {
        helloWord(args);
        verifyDataBaseConnection();
    }
}
