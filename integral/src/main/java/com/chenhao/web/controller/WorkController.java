package com.chenhao.web.controller;

import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentVo;
import com.chenhao.server.WorkService;
import com.chenhao.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:26
 */
@RestController
@RequestMapping("/v1/work")
public class WorkController {
    @Autowired
    WorkService workService;
    @PostMapping("/showWorks")
    public ResponseResult showWorks(@RequestBody Assignment assignment){
        //根据日期和作业id进行查询
        AssignmentVo assignmentVo = workService.showWorksByCondition(assignment);

        if(null!=assignmentVo){
            //返回数据
            return new ResponseResult(0,"操作成功",assignmentVo);
        }else{
            return new ResponseResult(0,"请检查条件",null);
        }
    }
}
