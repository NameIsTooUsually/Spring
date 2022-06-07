package com.chenhao.web.controller;

import com.chenhao.domain.User;
import com.chenhao.domain.UserVo;
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
 * @date 2022/6/7 13:24
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @GetMapping("/findByClassId")
    public ResponseResult findByClassId(){
        //从session中获取班级id
        Integer classId = (Integer) request.getSession().getAttribute("classId");
        //获取该班级的学生
        List<UserVo> list = userService.findByClassId(classId);

        if(null!=list){

            return new ResponseResult(0,"操作成功",list);
        }else{
            return new ResponseResult(1,"操作失败",null);
        }
    }

    @PostMapping("/addIntegral")
    public ResponseResult addIntegral(@RequestBody User user){
        //给指定id的学生加减分
        boolean flag = userService.addIntegral(user);
        if (flag){
            //操作成功
            return new ResponseResult(0,"操作成功","添加积分成功");
        }else{
            return new ResponseResult(1,"操作失败","添加积分失败");

        }
    }
}
