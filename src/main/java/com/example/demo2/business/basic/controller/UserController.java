package com.example.demo2.business.basic.controller;

import com.example.demo2.business.basic.service.GaodeMapService;
import com.example.demo2.business.basic.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  用户控制器
 */
@RestController
@RequestMapping("web/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * @Desciption: 查询昵称是否重复
    * @param nick 昵称
    * @Return: java.lang.String
    * @Author: ada
    * @Date: 2020/2/18 21:01
    * @Version: 1.0
    */
    @GetMapping("checkNick/{nick}")
    @ResponseBody
    public String checkNick(@PathVariable("nick") String nick){
        if(StringUtils.isEmpty(nick.trim())){
            return "查询的昵称不能为空";
        }
        Boolean isFalg=userService.isExistNick(nick.trim());
        if(isFalg){
            return "201";
        }
        return "200";
    }

    /*
     * @Desciption: 查询登录账号是否重复
     * @param uin 登录账号
     * @Return: java.lang.String
     * @Author: ada
     * @Date: 2020/2/18 21:01
     * @Version: 1.0
     */
    @GetMapping("checkUin/{uin}")
    @ResponseBody
    public String checkUin(@PathVariable("uin") String uloginName){
        if(StringUtils.isEmpty(uloginName.trim())){
            return "查询的登录账号不能为空";
        }
        Boolean isFalg=userService.isExistLoginName(uloginName.trim());
        if(isFalg){
            return "201";
        }
        return "200";
    }

    /*
    * @Desciption: 用户注册
    * @param uNickName  昵称
    * @param uLoginName 登录账号
    * @param pwd    登录密码
    * @param tel 手机号码
    * @Return: java.lang.String 201:昵称或账号不可注册 202：四个参数中间存在空 203 添加失败，程序异常 200 成功
    * @Author: ada
    * @Date: 2020/2/19 23:30
    * @Version: 1.0
    */
    @PostMapping("/")
    @ResponseBody
    public String register(@RequestParam("nick") String uNickName,
                           @RequestParam("uin") String uLoginName,
                           @RequestParam("pwd") String pwd,
                           @RequestParam("tel") String tel){
        if(StringUtils.isEmpty(uNickName) || StringUtils.isEmpty(uLoginName) || StringUtils.isEmpty(pwd) ||
                StringUtils.isEmpty(tel)){
            return "202";
        }
        //查询账号  昵称是否重复
        if(userService.isExistNickOrLoginName(uNickName,uLoginName)){
            return "201";
        }
        boolean falg=userService.addUser(uNickName,uLoginName,pwd,tel);
        if(falg){
            return "200";
        }
        return "203";
    }
}
