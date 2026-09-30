package fr.alban.dao;

/**
 * Classe pour pouvoir gérer les diverses exceptions liées
 * à la connection à la base de données.
 * Exemple donné dans le cours Java Avancé
 */
public class DataBaseException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private Exception exception;


    /**
     * Constructeur sans paramètre
     */
    public DataBaseException() {
        super("Problème avec la connexion à la base données");
    }

    /**
     * Constructeur avec le message uniquement
     * @param message de l'exception
     */
    public DataBaseException(String message) {
        /* Chaînage vers le constructeur sans paramètre pour
        * avoir le message : "il semble ...".
        * */
        this();
        this.message = message;
    }

    /**
     * Constructeur avec le message et l'erreur
     * @param message
     * @param exception;
     */
    public DataBaseException(String message, Exception exception) {
        this();
        this.message = message;
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getExceptionMessage() {
        return exception.getMessage();
    }
}
