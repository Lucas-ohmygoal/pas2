package com.jfl.pas2.service;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.constant.param.Parameter;
import com.jfl.pas2.domain.User;
import com.jfl.pas2.dto.login.UserLoginOutput;
import com.jfl.pas2.dto.login.UserLoginX1;
import com.jfl.pas2.dto.login.UserLoginZ1;
import com.jfl.pas2.dto.query.UserInfoQueryOutput;
import com.jfl.pas2.dto.query.UserInfoQueryX1;
import com.jfl.pas2.dto.query.UserInfoQueryZ1;
import com.jfl.pas2.dto.register.UserRegisterOutput;
import com.jfl.pas2.dto.register.UserRegisterX1;
import com.jfl.pas2.dto.register.UserRegisterZ1;
import com.jfl.pas2.dto.retrieve.UpdatePasswordOutput;
import com.jfl.pas2.dto.retrieve.UpdatePasswordX1;
import com.jfl.pas2.dto.retrieve.UpdatePasswordZ1;
import com.jfl.pas2.manager.UserManager;
import io.netty.util.internal.StringUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-07-02-4:56 PM
 */

@Service
public class UserService {

    @Autowired
    private UserManager userManager;
    @Autowired
    private MessageCodeService messageCodeService;


    /**
     * 用户注册
     * @param input
     */
    public UserRegisterOutput userRegister(UserRegisterX1 input) throws JSONException, ParseException {
        //数据检查
        checkInputData(input);
        //检查用户是否已存在
        checkUserName(input);
        //生成六位的用户号
        String userNumber = generateUserName();
        //写入数据
        userManager.writeAccountInfo(userNumber,input);
        //短信通知
        messageCodeService.registerNotification(input.getUserPhone(), userNumber);
        //返回接口
        UserRegisterZ1 output = new UserRegisterZ1();
        output.setUserNumber(userNumber);
        UserRegisterOutput userRegisterOutput = new UserRegisterOutput();
        userRegisterOutput.setUserRegisterZ1(output);
        return userRegisterOutput;
    }

    /**
     * 用户登录
     * @param input
     */
    public UserLoginOutput userLogin(UserLoginX1 input){
        UserLoginOutput output = new UserLoginOutput();
        UserLoginZ1 loginZ1 = new UserLoginZ1();
        //输入数据检查
        inputDataCheck(input);
        //校验用户密码
        List<User> userInfos = userManager.verifyUserPassword(input);
        User userInfo = new User();
        if (userInfos != null && !userInfos.isEmpty()){
            userInfo = userInfos.get(0);
            if (userInfo.getUserPassword().equals(input.getUserPassword())){
                loginZ1.setVerifyResult(Parameter.VERIFY_RESULT_TRUE);
                loginZ1.setVerifyInfo("登录成功！");
            }else{
                loginZ1.setVerifyResult(Parameter.VERIFY_RESULT_FALSE);
                loginZ1.setVerifyInfo("密码输入有误！");
            }
        }else{
            loginZ1.setVerifyResult(Parameter.VERIFY_RESULT_FALSE);
            loginZ1.setVerifyInfo("用户号不存在!");
        }
        //更新用户信息
        userManager.updateUserInfo(userInfo, input);
        output.setUserLoginZ1(loginZ1);
        return output;
    }

    /**
     * 用户信息查询
     */
    public UserInfoQueryOutput userQuery(UserInfoQueryX1 input){
        //数据检查
        checkQueryInput(input);
        //查询用户信息
        User userInfo = userManager.queryAccountInfo(input.getUserNumber());
        //数据返回
        return wrapUserInfo(userInfo);
    }

    /**
     * 密码更新
     * @param input
     */
    public UpdatePasswordOutput updatePassword(UpdatePasswordX1 input){
        //输入数据更新
        updateInfoChect(input);
        //校验手机号码
        User userInfo = userManager.queryAccountInfo(input.getUserId());
        if (!userInfo.getUserPhone().equals(input.getUserPhone())){
            throw new AppException(ErrorEnum.E00014, "您输入的手机号与已录入手机号不符，请重新输入！");
        }
        if (userInfo.getUserPassword().equals(input.getUserPassword())){
            throw new AppException(ErrorEnum.E00015, "新密码不可与旧密码相同，请重新输入！");
        }
        userManager.updateUserPassword(userInfo, input);
        UpdatePasswordOutput output = new UpdatePasswordOutput();
        UpdatePasswordZ1 updatePasswordZ1 = new UpdatePasswordZ1();
        updatePasswordZ1.setResult("Y");
        output.setUpdatePasswordZ1(updatePasswordZ1);

        return output;

    }

    /**
     * 密码更新-数据检查
     * @param input
     */
    public void updateInfoChect(UpdatePasswordX1 input){
        if (input.getUserId().isEmpty()){
            throw new AppException(ErrorEnum.E00012, "用户号输入不可为空！");
        }
        if (input.getUserPhone().isEmpty()){
            throw new AppException(ErrorEnum.E00003, "电话号码不可为空！");
        }
        if (input.getUserPassword().isEmpty()){
            throw new AppException(ErrorEnum.E00013, "新密码不可为空！");
        }
    }

    /**
     * 用户信息查询-数据检查
     */
    public void checkQueryInput(UserInfoQueryX1 input){

        if (input.getUserNumber().isEmpty()){
            throw new AppException(ErrorEnum.E00011, "用户号输入不可为空！");
        }
        if (input.getUserPriority() < 0 || input.getUserPriority() > 3){
            throw new AppException(ErrorEnum.E00004,"权限级别不可为空！");
        }
    }

    /**
     * 接口包装
     * @param userInfo
     * @return
     */
    public UserInfoQueryOutput wrapUserInfo(User userInfo){
        UserInfoQueryOutput output = new UserInfoQueryOutput();
        UserInfoQueryZ1 queryZ1 = new UserInfoQueryZ1();
        queryZ1.setUserNumber(userInfo.getUserId());
        queryZ1.setUserName(userInfo.getUserName());
        queryZ1.setUserPassword(userInfo.getUserPassword());
        queryZ1.setUserPriority(userInfo.getUserPriority());
        queryZ1.setIsMemorized(userInfo.getIsMemorized());
        queryZ1.setIsAutomatic(userInfo.getIsAutoLogin());
        output.setUserInfoQueryZ1(queryZ1);
        return output;
    }

    /**
     * 用户注册-检查用户是否存在
     * @param input
     */
    public void checkUserName(UserRegisterX1 input) {
        List<User> userInfo = userManager.selectAccountInfo(input);
        if (userInfo.size() >= 1){
            throw new AppException(ErrorEnum.E00005, "用户已存在，无需重复注册！");
        }
    }

    /**
     * 用户登陆-输入数据检查
     * @param input
     */
    public void inputDataCheck(UserLoginX1 input){
        if(input.getUserNumber().length() != Parameter.USER_NUMBER_SIZE){
            throw new AppException(ErrorEnum.E00008, "用户号输入不合法！");
        }
        if(!(input.getIsRememberPassword().equals(Parameter.PASSWORD_IS_REMEMBERED)) && !(input.getIsRememberPassword().equals(Parameter.PASSWORD_NOT_REMEMBERED))){
            throw new AppException(ErrorEnum.E00010,"是否记住密码标志输入有误!");
        }
        if(!(input.getIsRememberPassword().equals(Parameter.IS_AUTO_LOGIN)) && !(input.getIsRememberPassword().equals(Parameter.NOT_AUTO_LOGIN))){
            throw new AppException(ErrorEnum.E00011,"是否自动登录标志输入有误!");
        }
    }

    /**
     * 用户注册-输入数据检查
     * @param input
     */
    public void checkInputData(UserRegisterX1 input){
        //用户名不可为空
        if (StringUtil.isNullOrEmpty(input.getUserName())){
            throw new AppException(ErrorEnum.E00001, "用户名{0}不可为空!");
        }
        //密码不可为空
        if (StringUtil.isNullOrEmpty(input.getUserPassword())){
            throw new AppException(ErrorEnum.E00002, "密码不可为空！");
        }
        //电话不可为空
        if (StringUtil.isNullOrEmpty(input.getUserPhone())){
            throw new AppException(ErrorEnum.E00003, "电话号码不可为空！");
        }
        //权限级别不可为空
        if (input.getPriorityLevel() <= 0){
            throw new AppException(ErrorEnum.E00004, "权限级别不可为空！");
        }
    }

    /**
     * 用户注册-生成六位的用户号
     * @return
     */
    public String generateUserName(){
        int newNumber = (int)((Math.random()*9+1)*100000);
        return String.valueOf(newNumber);
    }
}
