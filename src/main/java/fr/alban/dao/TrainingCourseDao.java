package fr.alban.dao;

import fr.alban.models.TrainingCourse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Class TrainingCourseDao, cette classe fait la jonction entre la BDD et le model Training Courses
 */
public class TrainingCourseDao extends AbstractDao <TrainingCourse> {

    /**
     * Méthode équivalente à readall() pour une base de données
     * @return une lisye d'objet TrainingCourse
     */
    @Override
    public List<TrainingCourse> findAll() {
        return List.of();
    }

    /**
     * Méthode pour recherche un cours à partir de son identifiant (idCourse).
     * @param idCourse correspond à l'identifiant qui correspond à une ligne
     * @return une ligne d'enregistrement correspondante représentée par un objet
     * du modèle
     */
    @Override
    public Optional<TrainingCourse> findById(int idCourse) {
        return Optional.empty();
    }

    /**
     * Méthode pour créer un cours en bdd
     * Insère un nouveau Cours (formation) et met à jour son IdArticle généré (AUTO_INCREMENT).
     * @param entity correspond à un objet TrainingCourse
     * @return La formation créée
     */
    @Override
    public TrainingCourse create(TrainingCourse entity) {
        return null;
    }

    /**
     * Met à jour une formation existant.
     * @param entity en entrée l'instance d'un cours / d'une formation
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    @Override
    public boolean update(TrainingCourse entity) {
        return false;
    }

    /**
     * Supprime un article par son ID.
     * @param idCourse en entrée l'identifiant correspondant
     * au cours ou à la formation à supprimer
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    @Override
    public boolean delete(int idCourse) {
        return false;
    }

    /**
     * Méthode utilitaire pour convertir une ligne de ResultSet en objet Article.
     * Implémentation de la méthode abstraite définie dans AbstractDao.
     * @param rs le résultat de l'un des requêtes précédentes
     * @return l'objet TrainingCourse construit à partir des données récupérées en base
     * @throws SQLException
     */
    @Override
    protected TrainingCourse mapResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
