package com.jfl.pas2.dto.retrieve;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-15-7:54 PM
 */

@Setter
@Getter
public class UpdatePasswordX1 {

    /**
     * 用户号
     */
    private String userId;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户新密码
     */
    private String userPassword;

}
