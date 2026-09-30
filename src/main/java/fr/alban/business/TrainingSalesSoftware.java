package fr.alban.business;

import fr.alban.dao.OrderDao;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;

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

    public List<TrainingCourse> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<TrainingCourse> courseList) {
        this.courseList = courseList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
     * Une sécurité est mise pour vérifier si la saisie de l'utilisateur est vide ou nulle.
     * La saisie de l'utilisateur mise en minuscule
     * @param searchString le mot de recherche (exemple : "java")
     * @param listOfTrainingCourses la liste pré restreinte de formation.
     * Ce n'est pas toujours la liste complète de formation pour mettre une recherche combinée de critères
     * @return ArrayListe de TrainingCourse
     */
    public ArrayList<TrainingCourse> searchByName(String searchString, List<TrainingCourse> listOfTrainingCourses){
        ArrayList<TrainingCourse> resultats = new ArrayList<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return resultats;
        }

        String searchLowercase = searchString.toLowerCase();

        for (TrainingCourse course : listOfTrainingCourses) {
            if (course!= null){
                boolean isPresentInTitle = course.getNameCourse().toLowerCase().contains(searchLowercase);
                boolean isPresentInDescription = course.getDescriptionCourse().toLowerCase().contains(searchLowercase);

                if (isPresentInTitle || isPresentInDescription) {
                    resultats.add(course);
                }
            }
        }

        return resultats;
    }

    /**
     * Méthode pour rechercher un mot clef dans le titre ou la description
     * le recherche se fait sans ternir compte de la casse (majuscule ou minuscule)
     * Une sécurité est mise pour vérifier si la saisie de l'utilisateur est vide ou nulle.
     * @param searchString le mot de recherche "Présentiel" ou "Distantiel
     * @param listOfTrainingCourses la liste pré restreinte de formation.
     * Ce n'est pas toujours la liste complète de formation pour mettre une recherche combinée de critères
     * @return ArrayListe de TrainingCourse
     */
    public ArrayList<TrainingCourse> filterByTrainingCourseFormat(String searchString, List<TrainingCourse> listOfTrainingCourses){
        ArrayList<TrainingCourse> resultats = new ArrayList<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return resultats;
        }

        for (TrainingCourse course : listOfTrainingCourses) {
            if (course.getTrainingFormat() != null){
                boolean isOnSideTraining = searchString.equals("Présentiel");
                boolean isDistanceTraining = searchString.equals("Distantiel");
                boolean isFormatTrainingSuitable = searchString.equals(course.getTrainingFormat());
                if (isDistanceTraining && isFormatTrainingSuitable) {
                    resultats.add(course);
                }
                if (isOnSideTraining && isFormatTrainingSuitable){
                    resultats.add(course);
                }
            }
        }

        return resultats;
    }

    /**
     * La méthode permet d'afficher un tableau formaté.
     * Elle utilise la HasMap de chaque objet TrainingCourse pour afficher le tableau.
     * @param courses c'est une liste d'objet TrainingCourse
     */
    public void displayFormatArray(List<TrainingCourse> courses){
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
}
