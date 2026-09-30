package fr.alban;

import static java.lang.System.*;

import fr.alban.dao.DataBaseException;
import fr.alban.dao.TrainingCourseDao;

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
     */
    public static void verifyDataBaseConnection() {
        TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
        if (trainingCourseDao.isAccessible()) {
            out.println("Connexion à la base de données réussie !");
        } else {
            out.println("Connexion à la base de données impossible !");
        }
    }

    public static void main(String[] args) {
        helloWord(args);
        verifyDataBaseConnection();
    }
}
