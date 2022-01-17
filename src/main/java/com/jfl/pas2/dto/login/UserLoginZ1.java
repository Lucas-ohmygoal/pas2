package com.jfl.pas2.dto.login;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-11-11:25 PM
 */

@Setter
@Getter
public class UserLoginZ1 {

    /**
     * 校验结果
     */
    private String verifyResult;

    /**
     * 校验返回信息
     */
    private String verifyInfo;
}
