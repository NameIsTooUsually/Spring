package com.chenhao.web.controller;

import com.chenhao.domain.KsClass;
import com.chenhao.domain.LoginDto;
import com.chenhao.domain.User;
import com.chenhao.server.ClassService;
import com.chenhao.server.UserService;
import com.chenhao.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 11:50
 */
@RequestMapping("/v1/login")
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ClassService classService;
    @Autowired
    HttpServletRequest request;


    //验证是否是老师账号
    @GetMapping("/{mobile}")
    public ResponseResult isTeacher(@PathVariable String mobile) {
        User user = userService.isTeacher(mobile);
        if(null!=user && user.getRoleId()==1){
            //是老师账号，将老师账号的班级

            //是老师账号，需要返回班级列表
            List<KsClass> classes = classService.findAllClass();
            //返回班级列表
            return new ResponseResult(0,"是老师",classes);
        }else{
            //学生账号，直接返回消息
            return new ResponseResult(1,"是学生",null);
        }
    }

    @PostMapping("/in")
    public ResponseResult login(@RequestBody LoginDto loginDto){
        //登录，验证账号密码
        User user = userService.longin(loginDto);

        if(null!=user){
            //登录成功 班级信息存入session
            request.getSession().setAttribute("classId",loginDto.getClassId());
            return new ResponseResult(0,"操作成功",null);
        }else{
            return new ResponseResult(1,"用户名或密码错误",null);
        }
    }
}
