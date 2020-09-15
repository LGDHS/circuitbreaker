package com.dhs.exception;

/**
 * @author hongsend
 * @date 2020/9/15 21:34
 * @desc
 */
public class BizException  extends RuntimeException {
    private static final long serialVersionUID = -2147662480221819283L;
    public BizException(String message) {
        super(message);
    }
}
