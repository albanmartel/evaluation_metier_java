package fr.alban.business;

import fr.alban.dao.OrderDao;
import fr.alban.dao.TrainingCourseDao;
import fr.alban.models.*;

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
}
