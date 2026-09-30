package fr.alban.dao;

/* Lecture de fichier */

import java.io.IOException;
import java.io.InputStream;
/* Gérer la liaison avec la BDD SQL */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/* Pour utiliser une liste ordonnée d'éléments */
import java.util.List;
/* Permet de gérer les erreurs NUllPointerException*/
import java.util.Optional;
/* Librairie conçue pour travailler avec des dictionnaires clef / valeur */
import java.util.Properties;

public abstract class AbstractDao<T> {

    // Méthodes CRUD abstraites que chaque DAO concrète doit implémenter

    /**
     * Méthode équivalente à readall() pour une base de données
     * @return une liste d'objet T
     */
    public abstract List<T> findAll();

    /**
     * Méthode pour rechercher un objet T de son identifiant (id).
     * @param id correspond à l'identifiant qui correspond à une ligne
     * @return une instance de l'objet T
     */
    public abstract Optional<T> findById(int id);

    /**
     * Méthode pour créer un T en bdd
     * Insère les données d'un objet T dans un id généré (AUTO_INCREMENT).
     * @param entity fournit une instance T de l'objet à insérer.
     * @return L'objet T
     */
    public abstract T create(T entity);

    /**
     * Met à jour l'enregistrement existant d'un objet T.
     * @param entity en entrée l'objet T lui-même
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    public abstract boolean update(T entity);

    /**
     * Supprime un objet T par son ID.
     * @param id en entrée l'identifiant correspondant
     * au cours ou à la formation à supprimer
     * @return vrai ou faux en fonction du résultat de l'opération
     */
    public abstract boolean delete(int id);

    /**
     * Méthode utilitaire pour convertir un ResultSet en objet Métier (T).
     */
    protected abstract T mapResultSet(ResultSet rs) throws SQLException;

}

