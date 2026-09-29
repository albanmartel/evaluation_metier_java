package fr.alban;

import static java.lang.System.*;
import fr.alban.dao.AbstractDao;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.TrainingCourse;

public class App {

    /**
     * Méthode vestige de l'ancienne application "HelloWord
     *
     * @param args le tableau de String envoyé par le main
     */
    public static void helloWord(String[] args) {
        out.println("Hello World!");
    }

    public static void verifyDataBaseConnection() {
        out.println("Connect to database...");
        TrainingCourseDao daoCourse = new TrainingCourseDao();
    }


    public static void main(String[] args) {
        helloWord(args);
        verifyDataBaseConnection();
    }
}
