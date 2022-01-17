package com.jfl.pas2;

import com.jfl.pas2.domain.UserExample;
import com.jfl.pas2.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Pas2ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo("755343");
        userMapper.selectByExample(example);
    }

}
