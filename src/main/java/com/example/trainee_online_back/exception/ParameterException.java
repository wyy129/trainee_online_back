package com.example.trainee_online_back.exception;
/** 
 * @description: 参数异常
 * @author wangyangyang 
 * @date: 2022/6/13 13:16
 * @return: 
 */
public class ParameterException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;

    public ParameterException(String msg){
        super(msg);
        this.code = 500;
    }

    public ParameterException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
