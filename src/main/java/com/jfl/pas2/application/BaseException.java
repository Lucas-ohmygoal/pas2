package com.jfl.pas2.application;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-05-5:23 PM
 */
@Getter
@Setter
class BaseException extends RuntimeException {

    public BaseException(ResponseEnum responseEnum,  String message){
        this.error = new ErrorMessage(responseEnum.getCode(), responseEnum.getMessage());
        System.out.println(responseEnum + "-" + message);
    }

    public BaseException(ResponseEnum responseEnum, Object[] args, String message){
        this.error = new ErrorMessage(responseEnum.getCode(), responseEnum.getMessage());
        System.out.println(responseEnum + "-" + message);
    }

    public BaseException(ResponseEnum responseEnum, Object[] args, String message,Throwable cause){
        this.error = new ErrorMessage(responseEnum.getCode(), responseEnum.getMessage());
        System.out.println(responseEnum + "-" + message);
    }

    private ErrorMessage error;

}
