package fr.alban;

import static java.lang.System.*;

import fr.alban.business.TrainingSalesSoftware;
import fr.alban.dao.TrainingCourseDao;


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

    /**
     * La méthode permet d'afficher un tableau formaté.
     * Elle utilise la HasMap de chaque objet TrainingCourse pour afficher le tableau.
     * @param courses c'est une liste d'objet TrainingCourse
     */
    public static void displayFormatArray(){
        TrainingSalesSoftware trainingSalesSoftware = new TrainingSalesSoftware();
        trainingSalesSoftware.init();
        trainingSalesSoftware.displayFormatArray(trainingSalesSoftware.getCourseList());
    }

    public static void main(String[] args) {
        helloWord(args);
        out.println();
        verifyDataBaseConnection();
        out.println();
        displayFormatArray();
    }
}
