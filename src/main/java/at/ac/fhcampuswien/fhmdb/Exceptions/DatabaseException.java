package at.ac.fhcampuswien.fhmdb.Exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException {
    public DatabaseException(){}
    public DatabaseException(String message, Throwable cause){
        super(message, cause);
    }
}
