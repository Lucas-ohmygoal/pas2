package com.jfl.pas2.manager;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.constant.param.Parameter;
import com.jfl.pas2.domain.User;
import com.jfl.pas2.domain.UserExample;
import com.jfl.pas2.dto.login.UserLoginX1;
import com.jfl.pas2.dto.login.UserLoginZ1;
import com.jfl.pas2.dto.register.UserRegisterX1;
import com.jfl.pas2.dto.retrieve.UpdatePasswordX1;
import com.jfl.pas2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-07-03-10:40 AM
 */

@Component
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    /**
     * 写入账号信息
     */
    public void writeAccountInfo(String userNumber, UserRegisterX1 input){

        User user = new User();
        user.setUserId(userNumber);
        user.setUserName(input.getUserName());
        user.setUserPassword(input.getUserPassword());
        user.setUserPhone(input.getUserPhone());
        user.setUserPriority(input.getPriorityLevel());
        user.setIsMemorized("N");
        user.setIsAutoLogin("N");

        if (userMapper.insertSelective(user) < 0){
            throw new AppException(ErrorEnum.E00007, "写入账号信息表出错！");
        }
    }

    /**
     * 根据姓名和电话号码查询账号信息
     */
    public List<User> selectAccountInfo(UserRegisterX1 input){
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(input.getUserName())
                                .andUserPhoneEqualTo(input.getUserPhone());
        List<User> userList = userMapper.selectByExample(example);
        if (userList == null){
            throw new AppException(ErrorEnum.E00006, "查询账号信息出错！");
        }
        return userList;
    }

    /**
     * 根据用户号查询用户信息
     */
    public User queryAccountInfo(String userNumber){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(userNumber);
        List<User> userList = userMapper.selectByExample(example);
        if (userList == null || userList.isEmpty()){
            throw new AppException(ErrorEnum.E00006, "查询用户信息出错！");
        }
        return userList.get(0);
    }

    /**
     * 校验用户密码
     */
    public List<User> verifyUserPassword(UserLoginX1 input){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(input.getUserNumber());
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    /**
     * 更新用户设置
     */
    public void updateUserInfo(User userInfo, UserLoginX1 input){
        String isMemorized = "N";
        String isAutomatic = "N";
        if (input.getIsRememberPassword().equals(Parameter.PASSWORD_IS_REMEMBERED)){
            isMemorized = "Y";
        }
        if (input.getIsAutoLogin().equals(Parameter.IS_AUTO_LOGIN)){
            isAutomatic = "Y";
        }
        userInfo.setIsMemorized(isMemorized);
        userInfo.setIsAutoLogin(isAutomatic);
        userMapper.updateByPrimaryKey(userInfo);
    }

    /**
     * 更新密码
     */
    public void updateUserPassword(User userInfo, UpdatePasswordX1 input){

        userInfo.setUserPassword(input.getUserPassword());
        userMapper.updateByPrimaryKey(userInfo);
    }

}
