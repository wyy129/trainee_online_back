package com.example.trainee_online_back.exception;

/**
 * @description:
 * @author: wunan
 * @company: Pactera Technology Co.,Ltd
 * @since: 2021/8/20 11:27
 * @version: V1.0
 **/
public class BasicInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int code;

    public BasicInfoException(String msg){
        super(msg);
        this.code = -1;
    }

    public BasicInfoException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
