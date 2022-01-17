package com.jfl.pas2.controller;

import com.jfl.pas2.dto.code.MessageCodeInput;
import com.jfl.pas2.dto.code.MessageCodeOutput;
import com.jfl.pas2.dto.login.UserLoginInput;
import com.jfl.pas2.dto.login.UserLoginOutput;
import com.jfl.pas2.dto.query.UserInfoQueryInput;
import com.jfl.pas2.dto.query.UserInfoQueryOutput;
import com.jfl.pas2.dto.register.UserRegisterInput;
import com.jfl.pas2.dto.register.UserRegisterOutput;
import com.jfl.pas2.dto.retrieve.UpdatePasswordInput;
import com.jfl.pas2.dto.retrieve.UpdatePasswordOutput;
import com.jfl.pas2.service.MessageCodeService;
import com.jfl.pas2.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


/**
 * @author Bin Liu
 * @date 2021-07-02-4:36 PM
 */

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageCodeService messageCodeService;

    /**
     * 用户注册
     * @param input
     * @return
     */
    @PostMapping("/register")
    public UserRegisterOutput userRegister(@RequestBody UserRegisterInput input) throws JSONException, ParseException {
        return userService.userRegister(input.getUserRegisterX1());
    }

    /**
     * 用户登陆
     * @param input
     * @return
     */
    @PostMapping("/login")
    public UserLoginOutput userLogin(@RequestBody UserLoginInput input){
        return userService.userLogin(input.getUserLoginX1());
    }

    /**
     * 用户信息查询
     * @param input
     * @return
     */
    @PostMapping("/query")
    public UserInfoQueryOutput userQuery(@RequestBody UserInfoQueryInput input){
        return userService.userQuery(input.getUserInfoQueryX1());
    }

    /**
     * 获取短信验证码
     * @param input
     * @return
     */
    @PostMapping("/code")
    public MessageCodeOutput getMessageCode(@RequestBody MessageCodeInput input) throws JSONException, ParseException {
        return messageCodeService.getCode(input.getMessageCodeX1().getPhone());
    }

    /**
     * 更新密码
     * @param input
     * @return
     */
    @PostMapping("/update")
    public UpdatePasswordOutput updatePassword(@RequestBody UpdatePasswordInput input){
        return userService.updatePassword(input.getUpdatePasswordX1());
    }
}
