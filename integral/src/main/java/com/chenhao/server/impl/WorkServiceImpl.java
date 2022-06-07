package com.chenhao.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentVo;
import com.chenhao.mapper.WorkMapper;
import com.chenhao.server.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:38
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public AssignmentVo showWorksByCondition(Assignment assignment) {
        /*LambdaQueryWrapper<Assignment> qw = new LambdaQueryWrapper();
        qw.eq(Assignment::getCreatedOn,assignment.getCreatedOn())
                .eq(Assignment::getAssignmentType,assignment.getAssignmentType());*/

        List<Assignment> assignments = workMapper.showWorksByCondition();
        if(null!=assignment){


        }
        return null;
    }
}
