package by.epam.minchuk.task1.exception;

public class IncorrectArgumentExeption extends Exception {
    public IncorrectArgumentExeption() {
    }

    public IncorrectArgumentExeption(String message) {
        super(message);
    }

    public IncorrectArgumentExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectArgumentExeption(Throwable cause) {
        super(cause);
    }

    public IncorrectArgumentExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
