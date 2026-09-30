package fr.alban.business;

import fr.alban.dao.OrderDao;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Cette classe est la classe métier de l'application vente de formation.
 * La classe principale pour le projet d'évaluation JAVA
 */
public class TrainingSalesSoftware {

    /* Ses paramètres sont fait pour accéder rapidement à des groupements d'objets
    * instantiés à partir de la BDD */
    private Map<Integer, TrainingCourse> courseMap;
    private List<TrainingCourse> courseList;
    private Map<Integer, Order> orderMap;
    private List<Order> orderList;
    private Map<Integer, OrderLine> orderLineMap;
    private List<OrderLine> orderLineList;
    private Map<Integer, Client> clientMap;
    private List<Client> clientList;
    private Map<Integer, User> userMap;
    private List<User> userList;

    /**
     * Constructeur sans paramètre de la classe TrainingSalesSoftware
     */
    public TrainingSalesSoftware(){
    }

    public Map<Integer, TrainingCourse> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<Integer, TrainingCourse> courseMap) {
        this.courseMap = courseMap;
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public Map<Integer, OrderLine> getOrderLineMap() {
        return orderLineMap;
    }

    public void setOrderLineMap(Map<Integer, OrderLine> orderLineMap) {
        this.orderLineMap = orderLineMap;
    }

    public Map<Integer, Client> getClientMap() {
        return clientMap;
    }

    public void setClientMap(Map<Integer, Client> clientMap) {
        this.clientMap = clientMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    /**
     * Methode qui va construire des listes d'objet
     */
    public void init(){
        TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
        this.courseList = trainingCourseDao.findAll();
        this.courseMap = this.courseList.stream().collect(Collectors.toMap(
                TrainingCourse::getIdCourse,
                Function.identity()
        ));
    }

    /**
     * Méthode pour rechercher un mot clef dans le titre ou la description
     * le recherche se fait sans ternir compte de la casse (majuscule ou minuscule)
     * @param searchString le mot de recherche (exemple : "java")
     * @param listOfTrainingCourses la liste pré restreinte de formation.
     * Ce n'est pas toujours la liste complète de formation pour mettre une recherche combinée de critères
     * @return ArrayListe de TrainingCourse
     */
    public ArrayList<TrainingCourse> searchByName(String searchString, List<TrainingCourse> listOfTrainingCourses){
        ArrayList<TrainingCourse> resultats = new ArrayList<>();
        for (TrainingCourse course : listOfTrainingCourses) {
            if (course.getNameCourse() != null
                    && course.getNameCourse().toLowerCase().contains(searchString)
                    || course.getDescriptionCourse().toLowerCase().contains(searchString)
            ) {
                resultats.add(course);
            }
        }

        return resultats;
    }

    /**
     * Méthode pour rechercher un mot clef dans le titre ou la description
     * le recherche se fait sans ternir compte de la casse (majuscule ou minuscule)
     * @param searchString le mot de recherche "Présentiel" ou "Distantiel
     * @param listOfTrainingCourses la liste pré restreinte de formation.
     * Ce n'est pas toujours la liste complète de formation pour mettre une recherche combinée de critères
     * @return ArrayListe de TrainingCourse
     */
    public ArrayList<TrainingCourse> filterByTrainingCourseFormat(String searchString, List<TrainingCourse> listOfTrainingCourses){
        ArrayList<TrainingCourse> resultats = new ArrayList<>();
        if (searchString == "Présentiel") {
            for (TrainingCourse course : courseList) {
                if (course.getTrainingFormat() != null && course.getTrainingFormat() == "Présentiel") {
                    resultats.add(course);
                }
            }
        }

        if (searchString == "Distantiel") {
            for (TrainingCourse course : courseList) {
                if (course.getTrainingFormat() != null && course.getTrainingFormat() == "Distantiel") {
                    resultats.add(course);
                }
            }
        }

        return resultats;
    }
}
