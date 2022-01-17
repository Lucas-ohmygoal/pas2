package com.jfl.pas2.dto.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-13-11:06 AM
 */

@Setter
@Getter
public class UserInfoQueryZ1 {

    /**
     * 用户号
     */
    private String userNumber;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户权限
     */
    private int userPriority;

    /**
     * 是否记住密码
     */
    private String isMemorized;

    /**
     * 是否自动登录
     */
    private String isAutomatic;
}
