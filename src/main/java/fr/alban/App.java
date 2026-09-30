package fr.alban;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.List;

import fr.alban.business.TrainingSalesSoftware;
import fr.alban.dao.DataBaseException;
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
     * Méthode pour vérifier que l'affichage de toutes les formations de la base fonctionne
     */
    public static void verifyTrainingCourseFindAll(){
        TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
        List<TrainingCourse> courses = trainingCourseDao.findAll();
        for (TrainingCourse course : courses){
            out.println(course);
        }
    }

    /**
     * La méthode permet d'afficher un tableau formaté.
     * Elle utilise la HasMap de chaque objet TrainingCourse pour afficher le tableau.
     * @param courses c'est une liste d'objet TrainingCourse
     */
    public static void git a{
        TrainingSalesSoftware trainingSalesSoftware = new TrainingSalesSoftware();
        trainingSalesSoftware.init();
        trainingSalesSoftware.displayFormatArray(trainingSalesSoftware.getCourseList());
    }

    public static void main(String[] args) {
        helloWord(args);
        out.println();
        verifyDataBaseConnection();
        out.println();
        //verifyTrainingCourseFindAll();
        out.println();
        displayFormatArray();
    }
}
