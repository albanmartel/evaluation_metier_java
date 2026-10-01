package fr.alban.models;

import java.math.BigDecimal;

/**
 * Classe OrderLine sert de modèle pour représenter la table order_line de la BDD
 */
public class OrderLine {
    private Integer idOrderLine;
    private Integer idOrder;
    private Integer idCourse;
    private BigDecimal unitPrice;
    private Integer quantity;
}
