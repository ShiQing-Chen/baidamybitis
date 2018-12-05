package com.chen.baida.exception;


/**
 * Created with IntelliJ IDEA.
 * User: HanHongmin
 * Date: 13-9-3
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */
public class DinSmoothException extends Exception {
    private static final long serialVersionUID = 1L;
    public DinSmoothException() {
        super();
    }

    public DinSmoothException(String message) {
        super(message);
    }

    public DinSmoothException(String message, Throwable cause) {
        super(message, cause);
    }

    public DinSmoothException(Throwable cause) {
        super(cause);
    }

    public DinSmoothException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
