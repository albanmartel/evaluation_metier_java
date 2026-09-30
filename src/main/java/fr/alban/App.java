package fr.alban;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.List;

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
    public static void displayFormatArray(List<TrainingCourse> courses){
        out.printf("| %-32s | %-5s | %-70s | %-3s | %-10s | %-3s | %n", "Nom", "Prix", "Description", "Durée", "Format", "id");
        out.println("---------------------------------------------" +
                "-------------------------------------------------" +
                "--------------------------------------------------");
        for (TrainingCourse course: courses){
            HashMap<String, String> hashMap = course.trainingCourseDictionnary();
            out.printf("| %-32s | %-5s | %-70s | %-5s | %-10s | %-3s | %n",
                    hashMap.get("nameCourse"),
                    hashMap.get("price"),
                    hashMap.get("descriptionCourse"),
                    hashMap.get("duration"),
                    hashMap.get("TrainingFormat"),
                    hashMap.get("idCourse"));
        }
    }

    public static void main(String[] args) {
        helloWord(args);
        verifyDataBaseConnection();
        //verifyTrainingCourseFindAll();
        TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
        List<TrainingCourse> courses =  trainingCourseDao.findAll();

        displayFormatArray(courses);
    }
}
