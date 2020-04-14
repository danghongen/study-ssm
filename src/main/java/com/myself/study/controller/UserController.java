package com.myself.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.myself.study.common.Vo.ResultInfo;
import com.myself.study.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/ssm/")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo loginFor(@RequestBody JSONObject jsonObject){
        ResultInfo result=new ResultInfo();
        String userName=jsonObject.getString("name");
        System.out.print("日志");
        String password=jsonObject.getString("password");
        Subject subject= SecurityUtils.getSubject();//作用？
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        try{
            //未认证登陆？
            if (!subject.isAuthenticated()){
                subject.login(token);
                result.setMsg("用户验证通过");
            }else {
                result.setMsg("用户已经登陆");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public ResultInfo loginOut(@RequestBody JSONObject jsonObject){
        ResultInfo result =new ResultInfo();
        Subject subject=SecurityUtils.getSubject();
        try {
            if (subject.isAuthenticated()){
                subject.logout();
                result.setMsg("登陆退出成功");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
        }
        return  result;
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultInfo addUser(@RequestBody JSONObject jsonObject){
        ResultInfo resultInfo=new ResultInfo();
        String userName=jsonObject.getString("name");
        String password=jsonObject.getString("password");
        //MD5的盐加密(盐加密的时候需要把盐也存入数据库中)
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        int times=2;
        String na="md5";
        String passwordEncode=new SimpleHash(na,password,salt,times).toString();
        try {
            userService.addUserByNormal(userName,password);
            resultInfo.setMsg("添加成功");
        }catch (Exception e){
            resultInfo.setMsg(e.getMessage());
        }
        return resultInfo;
    }
}
