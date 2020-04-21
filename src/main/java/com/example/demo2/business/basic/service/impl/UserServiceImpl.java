package com.example.demo2.business.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo2.business.basic.mapper.UserMapper;
import com.example.demo2.business.basic.service.UserService;
import com.example.demo2.business.basic.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Userservice实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String uLoginName,String uPassword) {
        return userMapper.login(uLoginName,uPassword);
    }

    @Override
    public boolean isExistNick(String uNickName) {
        int num=userMapper.findByUnickName(uNickName);
        if(num>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistLoginName(String uLoginName) {
        int num=userMapper.findByULoginName(uLoginName);
        if(num>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistNickOrLoginName(String uNickName, String uLoginName) {
        int num=userMapper.isExistNickOrLoginName( uNickName,  uLoginName);
        return false;
    }

    @Override
    public boolean addUser(String uNickName, String uLoginName, String uPassword, String uTel) {
        try{
            userMapper.addUser(uNickName,uLoginName,uPassword,uTel);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
