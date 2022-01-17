package com.jfl.pas2.dto.login;

import io.lettuce.core.dynamic.batch.BatchSize;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Bin Liu
 * @date 2021-07-11-8:33 PM
 */


@Setter
@Getter
public class UserLoginX1 {

    /**
     * 用户号
     */
    @Size(max = 6, message = "用户号输入有误")
    private String userNumber;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 是否记住密码
     */
    @NotBlank
    private String isRememberPassword;

    /**
     * 是否自动登陆
     */
    @NotBlank
    private String isAutoLogin;

}
