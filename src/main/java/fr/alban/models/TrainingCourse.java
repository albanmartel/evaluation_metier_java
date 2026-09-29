package fr.alban.models;

import java.math.BigDecimal;
import java.util.HashMap;

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

    public TrainingCourse() {
        this.idCourse = 0;
        this.nameCourse = "unknown";
        this.descriptionCourse = "";
        this.TrainingFormat = "";
        this.duration = 0;
        this.price = new BigDecimal(0)
    }

    public TrainingCourse(Integer idCourse, String nameCourse, String descriptionCourse, String TrainingFormat, int duration, BigDecimal price) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.descriptionCourse = descriptionCourse;
        this.TrainingFormat = TrainingFormat;
        this.duration = duration;
        this.price = price;
    }

    /**
     *
     * @return String qui permet d'afficher tous les paramètres de l'instance
     */
    @Override
    public String toString() {
        return "idCourse=" + idCourse + ", nameCourse=" + nameCourse + ", descriptionCourse=" + descriptionCourse + ", TrainingFormat=" + TrainingFormat + ", duration=" + duration + ", price=" + price;
    }

    /**
     * Cette méthode permet d'avoir un tableau associatif de l'instance en cours
     * @return HashMap <String, String>
     *
     */
    public HashMap<String, String>  trainingCourseDictionnary() {
        HashMap<String, String> map = new HashMap<>();
        map.put("idCourse", String.valueOf(idCourse));
        map.put("nameCourse", nameCourse);
        map.put("descriptionCourse", descriptionCourse);
        map.put("TrainingFormat", TrainingFormat);
        map.put("duration", String.valueOf(duration));
        map.put("price", String.valueOf(price));

        return map;
    }
}
