package com.jfl.pas2.dto.register;


import lombok.Getter;
import lombok.Setter;


/**
 * @author Bin Liu
 * @date 2021-07-03-7:17 AM
 */

@Getter
@Setter
public class UserRegisterX1 {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 权限等级
     */
    private int priorityLevel;

}
