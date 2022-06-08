package com.chenhao.web.controller;

import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentDto;
import com.chenhao.domain.AssignmentVo;
import com.chenhao.domain.WorkDto;
import com.chenhao.server.WorkService;
import com.chenhao.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public ResponseResult showWorks(@RequestBody WorkDto workDto) {
        //根据日期和作业id进行查询
        List<AssignmentVo> list = workService.showWorksByCondition(workDto);

        if (null != list) {
            //返回数据
            return new ResponseResult(0, "操作成功", list);
        } else {
            return new ResponseResult(1, "请检查条件", null);
        }
    }

    @PostMapping("/publishWork")
    public ResponseResult publishWork(@RequestBody AssignmentDto assignmentDto) {
        boolean result = workService.addWork(assignmentDto);
        if (result) {
            //返回数据
            return new ResponseResult(0, "操作成功", "作业发布成功");
        } else {
            return new ResponseResult(1, "请检查条件", "发布失败");
        }
    }

    @PostMapping("/findNotWorkByTime")
    public ResponseResult findNotWorkByTime(@RequestBody WorkDto workDto){
        System.out.println(workDto);
       List<Map> list =  workService.findNotWorkByTime(workDto);
        if (null != list) {
            //返回数据
            return new ResponseResult(0, "操作成功", list);
        } else {
            return new ResponseResult(1, "请检查条件", null);
        }
    }
}
