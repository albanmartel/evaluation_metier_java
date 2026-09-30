package fr.alban.dao;

import fr.alban.models.TrainingCourse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * L'objectif de cette classe est uniquement de tester la connexion
 * à la base de données.
 * Elle est la copie de TrainingCourseDao
 */
public class TestDBConnexion extends AbstractDao <TrainingCourse> {
    /**
     * Méthode équivalente à readall() pour une base de données
     *
     * @return une liste d'objet T
     */
    @Override
    public List<TrainingCourse> findAll() {
        return List.of();
    }

    /**
     * Méthode pour rechercher un objet T de son identifiant (id).
     *
     * @param id correspond à l'identifiant qui correspond à une ligne
     * @return une instance de l'objet T
     */
    @Override
    public Optional<TrainingCourse> findById(int id) {
        return Optional.empty();
    }

    /**
     * Méthode pour créer un T en bdd
     * Insère les données d'un objet T dans un id généré (AUTO_INCREMENT).
     *
     * @param entity fournit une instance T de l'objet à insérer.
     * @return L'objet T
     */
    @Override
    public TrainingCourse create(TrainingCourse entity) {
        return null;
    }

    /**
     * Met à jour l'enregistrement existant d'un objet T.
     *
     * @param entity en entrée l'objet T lui-même
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    @Override
    public boolean update(TrainingCourse entity) {
        return false;
    }

    /**
     * Supprime un objet T par son ID.
     *
     * @param id en entrée l'identifiant correspondant
     *           au cours ou à la formation à supprimer
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    @Override
    public boolean delete(int id) {
        return false;
    }

    /**
     * Méthode utilitaire pour convertir un ResultSet en objet Métier (T).
     *
     * @param rs
     */
    @Override
    protected TrainingCourse mapResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
