package fr.alban;

import static java.lang.System.*;

import fr.alban.business.TrainingSalesSoftware;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.TrainingCourse;

import java.util.ArrayList;


public class App {

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
     * La méthode permet de faire 1 recherche par nom (exemple : java).
     * @param searchString la chaîne de recherche
     * @param trainingSalesSoftware l'instance de la classe business qui permet de récupérer toutes les formations
     */
    public static void searchTrainingCourseListe(String searchString, TrainingSalesSoftware trainingSalesSoftware){
        ArrayList<TrainingCourse> filterliste = trainingSalesSoftware.searchByName("Java", trainingSalesSoftware.getCourseList());
        trainingSalesSoftware.displayFormatArray(filterliste);
    }

    /**
     * La méthode permet de faire une sélection format de formation ("Distantiel" ou "Présentiel").
     * @param courseFormat la chaîne pour identifier le type de format recherché
     * @param trainingSalesSoftware l'instance de la classe business qui permet de récupérer toutes les formations
     */
    public static void searchByTrainingCourseFormat(String courseFormat, TrainingSalesSoftware trainingSalesSoftware){
        ArrayList<TrainingCourse> filterliste = trainingSalesSoftware.filterByTrainingCourseFormat(courseFormat, trainingSalesSoftware.getCourseList());
        trainingSalesSoftware.displayFormatArray(filterliste);
    }

    /**
     * La méthode permet de faire 2 recherches combinées par nom (exemple : java) et par format de formation ("Distantiel" ou "Présentiel").
     * @param searchString la chaîne de recherche
     * @param courseFormat le format de la formation
     * @param trainingSalesSoftware l'instance de la classe business qui permet de récupérer toutes les formations
     */
    public static void filterTrainingCourseListe(String searchString, String courseFormat, TrainingSalesSoftware trainingSalesSoftware){
        ArrayList<TrainingCourse> filterliste = trainingSalesSoftware.filterTrainingCourseListe(searchString, courseFormat, trainingSalesSoftware.getCourseList());
        trainingSalesSoftware.displayFormatArray(filterliste);
    }

    public static void main(String[] args) {
        out.println();
        verifyDataBaseConnection();
        out.println();
        out.println("Afficher toute les formations\n");
        TrainingSalesSoftware trainingSalesSoftware = displayFormatArray();
        out.println();
        out.println("Faire une recherche par nom \"Java\"\n");
        searchTrainingCourseListe("Java", trainingSalesSoftware);
        out.println();
        out.println("Filtrer les formations en \"Distantiel\"\n");
        searchByTrainingCourseFormat("Distantiel", trainingSalesSoftware);
        out.println();
        out.println("Faire une recherche par nom \"Java\" et en \"Présentiel\"\n");
        filterTrainingCourseListe("java", "Présentiel", trainingSalesSoftware);
    }
}
