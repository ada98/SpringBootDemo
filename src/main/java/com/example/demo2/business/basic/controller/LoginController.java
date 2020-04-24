package com.example.demo2.business.basic.controller;

import com.example.demo2.business.basic.service.UserService;
import com.example.demo2.business.basic.vo.User;
import com.example.demo2.util.ImageSecurityUtil;
import com.example.demo2.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
@Api(value="登陆controller",tags={"登陆操作接口"})
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @ApiOperation(value = "跳转登陆页面", notes = "跳转登陆页面")
    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView mv,HttpServletRequest request) throws IOException {
        /*ImageUtil imageUtil=new ImageUtil();
        Map<String,String> imageMap=imageUtil.getSlideSetting();
        //设置滑动图路径
        request.setAttribute("imageSlide",imageMap.get("imageSlide"));
        //设置截取路径
        request.setAttribute("imageCut",imageMap.get("imageCut"));
        HttpSession session=request.getSession();
        session.setAttribute("imageX",imageMap.get("x"));
        session.setAttribute("imageY",imageMap.get("y"));*/
        mv.setViewName("login");
        return mv;
    }

    @ApiOperation(value = "跳转首页页面", notes = "跳转首页页面")
    @GetMapping(value = "/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @ApiOperation(value = "跳转注册页面", notes = "跳转注册页面")
    @GetMapping(value = "/toRegister")
    public ModelAndView toRegister(ModelAndView mv) {
        mv.setViewName("register");
        return mv;
    }

    @ApiOperation(value = "登陆", notes = "登陆")
    @PutMapping(value="submit")
    public ModelAndView submit(HttpServletRequest request,ModelAndView mv) throws Exception {
        Destination destination = new ActiveMQQueue("web-queue");
        for (int i = 0; i < 10 ; i++){
            jmsMessagingTemplate.convertAndSend(destination, "topic"+i);
        }
        mv.setViewName("login");
        /*String userName=request.getParameter("u" );
        String password=request.getParameter("p");
        String vCode=request.getParameter("verifycode");
        String code=request.getSession().getAttribute("code").toString();
        if(StringUtils.isEmpty(vCode)){
            mv.addObject("info","请输入验证码");
            mv.setViewName("login");
        }else{
            if(!code.toUpperCase().equals(vCode.trim().toUpperCase())){
                mv.addObject("info","验证码错误");
                mv.setViewName("login");
            }else{
                if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
                    mv.addObject("info","请输入登录账号及密码");
                    mv.setViewName("login");
                }
                User user=userService.login(userName,password);
                if(user!=null){
                    HttpSession session=request.getSession();
                    session.setAttribute("userName", userName);
                    mv.setViewName("html/index");
                    mv.addObject("info","登录成功");
                }else{
                    mv.setViewName("login");
                    mv.addObject("info","账号或密码错误，请重新登陆");
                }
            }
        }*/
        return mv;
    }

    /*
    * @Desciption: ajax获取验证码，返回文件的输入流
    * @param response
    * @param request
    * @Return: void
    * @Author: ada
    * @Date: 2020/2/17 21:16
    * @Version: 1.0
    */
    @ResponseBody
    @RequestMapping(value = "/login/getSecurityCode", produces = {"application/json;charset=UTF-8"})
    public void getSecurityCode(HttpServletResponse response, HttpServletRequest request){
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        ImageSecurityUtil util = ImageSecurityUtil.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        request.getSession().setAttribute("code", code);
        // 输出打web页面
        try {
            ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
