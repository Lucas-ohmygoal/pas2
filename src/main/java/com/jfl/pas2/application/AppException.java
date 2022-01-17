package com.jfl.pas2.application;

/**
 * @author Bin Liu
 * @date 2021-07-05-4:49 PM
 */

public class AppException extends BaseException{

    private static final long serialVersionUID = 1L;

    public AppException(ResponseEnum responseEnum,  String message){
        super(responseEnum, message);
    }

    public AppException(ResponseEnum responseEnum, Object[] args, String message){
        super(responseEnum, args, message);
    }

    public AppException(ResponseEnum responseEnum, Object[] args, String message, Throwable cause){
        super(responseEnum,args, message, cause);
    }
}

