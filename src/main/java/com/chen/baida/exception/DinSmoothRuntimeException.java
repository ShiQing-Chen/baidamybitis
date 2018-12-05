package com.chen.baida.exception;


/**
 * Created with IntelliJ IDEA.
 * User: HanHongmin
 * Date: 13-9-3
 * Time: 下午4:49
 * To change this template use File | Settings | File Templates.
 */
public class DinSmoothRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DinSmoothRuntimeException() {
        super();
    }

    public DinSmoothRuntimeException(String message) {
        super(message);
    }

    public DinSmoothRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DinSmoothRuntimeException(Throwable cause) {
        super(cause);
    }

    public DinSmoothRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
