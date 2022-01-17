package com.jfl.pas2.application;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-06-8:41 PM
 */
@Getter
@Setter
public class ErrorMessage {
    private String code;
    private String message;

    public ErrorMessage(String code, String message){
        this.code = code;
        this.message = code + "-" + message;
    }

}
