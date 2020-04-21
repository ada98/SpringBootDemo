package com.example.demo2;

import com.example.demo2.business.basic.mapper.UserMapper;
import com.example.demo2.business.basic.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testInsert() {
        User user = userMapper.login("ada","ada");
        System.out.println(user);

    }



}
