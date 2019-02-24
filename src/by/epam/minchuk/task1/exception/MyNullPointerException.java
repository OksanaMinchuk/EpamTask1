package by.epam.minchuk.task1.exception;

public class MyNullPointerException extends Exception {
    public MyNullPointerException() {
    }

    public MyNullPointerException(String message) {
        super(message);
    }

    public MyNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNullPointerException(Throwable cause) {
        super(cause);
    }

    public MyNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
