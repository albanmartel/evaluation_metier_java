package fr.alban.business;

import fr.alban.dao.OrderDao;
import fr.alban.models.Client;
import fr.alban.models.OrderLine;
import fr.alban.models.TrainingCourse;
import fr.alban.models.User;

/**
 * Cette classe est la classe métier de l'application vente de formation.
 * La classe principale pour le projet d'évaluation JAVA
 */
public class TrainingSalesSoftware {

    /* Ses paramètres sont fait pour accéder rapidement à des groupements de classes
    * instantiées à partir de la BDD */
    private Map<Integer, TrainingCourse> courseMap;
    private Map<Integer, OrderDao> orderMap;
    private Map<Integer, OrderLine> orderLineMap;
    private Map<Integer, Client> clientMap;
    private Map<Integer, User> userMap;

}
