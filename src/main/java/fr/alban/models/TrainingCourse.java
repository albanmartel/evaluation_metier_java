package fr.alban.models;

import java.math.BigDecimal;

/**
 * Classe TrainingCourse sert de modèle pour représenter la table training_course de la BDD
 */
public class TrainingCourse {
    private Integer idCourse;
    private String nameCourse;
    private String descriptionCourse;
    private String TrainingFormat;
    private int duration;
    private BigDecimal price;
}
