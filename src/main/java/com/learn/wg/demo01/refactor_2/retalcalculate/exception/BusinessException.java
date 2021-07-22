package com.learn.wg.demo01.refactor_2.retalcalculate.exception;

/**
 * @author wanggang
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
