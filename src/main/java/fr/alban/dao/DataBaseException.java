package fr.alban.dao;

/**
 * Classe pour pouvoir gérer les diverses exceptions liées
 * à la connection à la base de données.
 * Exemple donné dans le cours Java Avancé
 */
public class DataBaseException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    private DataBaseException() {
        super("Il semble y avoir un problème avec la connexion à la base données");
    }
}
