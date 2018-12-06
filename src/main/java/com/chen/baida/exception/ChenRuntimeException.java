package com.chen.baida.exception;


/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class ChenRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ChenRuntimeException() {
        super();
    }

    public ChenRuntimeException(String message) {
        super(message);
    }

    public ChenRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChenRuntimeException(Throwable cause) {
        super(cause);
    }

    public ChenRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
