package com.chen.baida.exception;


/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class ChenException extends Exception {
    private static final long serialVersionUID = 1L;
    public ChenException() {
        super();
    }

    public ChenException(String message) {
        super(message);
    }

    public ChenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChenException(Throwable cause) {
        super(cause);
    }

    public ChenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
