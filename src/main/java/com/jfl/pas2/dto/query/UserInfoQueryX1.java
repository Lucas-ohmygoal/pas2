package com.jfl.pas2.dto.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-07-13-11:05 AM
 */

@Setter
@Getter
public class UserInfoQueryX1 {

    /**
     * 用户号
     */
    private String userNumber;

    /**
     * 用户权限
     */
    private int userPriority;
}
