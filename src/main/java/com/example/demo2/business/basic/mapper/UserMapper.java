package com.example.demo2.business.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo2.business.basic.vo.User;

public interface UserMapper extends BaseMapper<User> {
    /*
    * @Desciption: 根据登录账号和密码获取用户细腻些
    * @param uLoginName 登录账号
    * @param uPassword  密码
    * @Return: com.example.demo2.business.basic.vo.User
    * @Author: ada
    * @Date: 2020/2/18 20:49
    * @Version: 1.0
    */
    User login( String uLoginName, String uPassword);
    /*
    * @Desciption: 查询当前昵称使用数量
    * @param unickName 昵称
    * @Return: int
    * @Author: ada
    * @Date: 2020/2/18 20:49
    * @Version: 1.0
    */
    int findByUnickName(String uNickName);
    /*
    * @Desciption: 查询当前登录账号的数量
    * @param uLoginName 登录账号
    * @Return: int
    * @Author: ada
    * @Date: 2020/2/18 23:04
    * @Version: 1.0
    */
    int findByULoginName(String uLoginName);
    /*
    * @Desciption: 查询昵称或账号的数量
    * @param uNickName  昵称
    * @param uLoginName 账号
    * @Return: int
    * @Author: ada
    * @Date: 2020/2/20 10:32
    * @Version: 1.0
    */
    int isExistNickOrLoginName(String uNickName, String uLoginName);
    /*
    * @Desciption: 添加用户
    * @param uNickName  昵称
    * @param uLoginName 账号
    * @param uPassword  密码
    * @param uTel  手机
    * @Return: int
    * @Author: ada
    * @Date: 2020/2/20 11:02
    * @Version: 1.0
    */
    int addUser(String uNickName, String uLoginName, String uPassword, String uTel);
}
