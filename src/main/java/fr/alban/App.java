package fr.alban;

import static java.lang.System.*;

import fr.alban.business.TrainingSalesSoftware;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.TrainingCourse;

import java.util.ArrayList;


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
     * @return TrainingSalesSofware c'est une liste d'objet TrainingCourse initialisé
     */
    public static TrainingSalesSoftware displayFormatArray(){
        TrainingSalesSoftware trainingSalesSoftware = new TrainingSalesSoftware();
        trainingSalesSoftware.init();
        trainingSalesSoftware.displayFormatArray(trainingSalesSoftware.getCourseList());

        return trainingSalesSoftware;
    }

    /**
     * La méthode permet de faire 2 recherches combinées par nom (exemple : java) et par format de formation ("Distantiel" ou "Présentiel").
     * @param searchString la chaîne de recherche
     * @param courseFormat le format de la formation
     * @param trainingSalesSoftware l'instance de la classe business qui permet de récupérer toutes les formations
     */
    public static void filterTrainingCourseListe(String searchString, String courseFormat, TrainingSalesSoftware trainingSalesSoftware){
        ArrayList<TrainingCourse> filterliste = trainingSalesSoftware.searchByName("Java", trainingSalesSoftware.getCourseList());
        filterliste = trainingSalesSoftware.filterByTrainingCourseFormat(courseFormat, filterliste);
        trainingSalesSoftware.displayFormatArray(filterliste);
    }

    public static void main(String[] args) {
        helloWord(args);
        out.println();
        verifyDataBaseConnection();
        out.println();
        TrainingSalesSoftware trainingSalesSoftware = displayFormatArray();
        out.println();
        out.println(trainingSalesSoftware.searchByName("Java", trainingSalesSoftware.getCourseList()));
        out.println();
        out.println(trainingSalesSoftware.filterByTrainingCourseFormat("Distantiel", trainingSalesSoftware.getCourseList()));
        out.println();
        filterTrainingCourseListe("java", "Présentiel", trainingSalesSoftware);
    }
}
