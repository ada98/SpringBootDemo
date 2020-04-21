package com.example.demo2.business.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo2.business.basic.vo.User;

public interface UserService extends IService<User>  {
    /*
     * @Desciption:  根据登录账号和密码获取用户
     * @param uLoginName 登录账号
     * @param uPassword 密码
     * @Return: com.example.demo2.business.basic.vo.User
     * @Author: ada
     * @Date: 2020/1/14 22:44
     * @Version: 1.0
     */
    User login(String uLoginName,String uPassword);
    /*
    * @Desciption: 查询当前昵称是否重复
    * @param uNickName 昵称
    * @Return: boolean
    * @Author: ada
    * @Date: 2020/2/18 20:51
    * @Version: 1.0
    */
    boolean isExistNick(String uNickName);
    /*
    * @Desciption: 查询登录账号是否重复
    * @param uLoginName 登录账号
    * @Return: boolean
    * @Author: ada
    * @Date: 2020/2/18 23:02
    * @Version: 1.0
    */
    boolean isExistLoginName(String uLoginName);
    /*
    * @Desciption: 查询昵称或账号是否存在
    * @param uNickName   昵称
    * @param uLoginName  账号
    * @Return: boolean
    * @Author: ada
    * @Date: 2020/2/20 10:30
    * @Version: 1.0
    */
    boolean isExistNickOrLoginName(String uNickName,String uLoginName);

    /*
    * @Desciption: 添加用户
    * @param uNickName  昵称
    * @param uLoginName 账号
    * @param uPassword  密码
    * @param uTel  手机
    * @Return: boolean
    * @Author: ada
    * @Date: 2020/2/20 10:59
    * @Version: 1.0
    */
    boolean addUser(String uNickName,String uLoginName,String uPassword,String uTel);

}
