package fr.alban.models;

import java.time.LocalDate;

/**
 * Classe Order sert de modèle pour représenter la table order_training_course de la BDD
 */
public class Order {
    private Integer idOrder;
    private LocalDate orderDate;
    private Integer idClient;
    private Integer idUser;
}
