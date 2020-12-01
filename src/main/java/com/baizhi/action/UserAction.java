package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.ImageCodeUtil;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UserAction {
    private UserService userService;//为userservice提供set方法
    private User user;//提供set/get方法
    private String code;//提供set/get方法

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //登陆
    public String login() {
        //先调用userService方法
        User user1 = userService.queryOne(this.user.getUsername());
        if (user1 == null) {//判断如果user1等于空
            return "login";//跳转到登陆界面
        } else if (user.getPassword().equals(user1.getPassword())) {//用输入的密码与数据库的密码作比较 相同
            //获取HttpSession session
            HttpSession session = ServletActionContext.getRequest().getSession();
            //调用session的方法：setAttribute
            session.setAttribute("user", user1);
            //跳转到查所有action（struts.xml）
            return "queryAllAction";
        } else {
            //否则跳转到登陆（struts.xml配置文件中）
            return "login";
        }
    }

    //注册
    public String add() {
        //获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        //获取验证码
        String serverCode = (String) session.getAttribute("serverCode");
        //判断验证码   相同
        if (code.equals(serverCode)) {
            userService.save(user);
            //失败跳转到登陆action（struts.xml配置文件中）
            return "login";
        } else {
            //成功跳转到查所有
            return "regist";
        }
    }

    //生成验证码
    public String createImg() throws IOException {
        HttpSession session = ServletActionContext.getRequest().getSession();
        //获得随机字符
        String serverCode = ImageCodeUtil.getSecurityCode();

        //生成图片
        BufferedImage image = ImageCodeUtil.createImage(serverCode);
        //使用响应输出流把bufferedImage输出到client
        ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
        ImageIO.write(image, "gif", outputStream);
        System.out.println("验证码为：" + serverCode);
        session.setAttribute("serverCode", serverCode);
        return null;
    }

    //等出
    public String loginout() {
        //获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        //调用session的方法removeAttribute
        session.removeAttribute("user");
        //跳转到成功action（struts.xml配置文件）
        return "login";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
