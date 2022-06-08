package com.chenhao.server.impl;

import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentDto;
import com.chenhao.domain.AssignmentVo;
import com.chenhao.domain.WorkDto;
import com.chenhao.mapper.WorkMapper;
import com.chenhao.server.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<AssignmentVo> showWorksByCondition(WorkDto workDto) {

        List<AssignmentVo> list = new ArrayList<>();


        List<Assignment> assignments = workMapper.showWorksByCondition(workDto);

        if(null!=assignments){
            for (Assignment assignment1 : assignments) {
                //遍历每一条记录，拿出id
                Integer userId = assignment1.getUserId();

                //遍历集合，查看该id是否已经统计过，
                boolean flag = false;
                for (AssignmentVo assignmentVo : list) {
                    //该学生的作业已经统计过一次了
                    if(assignmentVo.getUid()==userId){
                        flag = true;
                        //将这条信息存入AssignmentVo
                        Map map = new HashMap();
                        map.put("workname",assignment1.getAssignmentName());
                        map.put("id",assignment1.getAssignmentId());
                        map.put("isComplete",assignment1.getStatus());
                        assignmentVo.getPracticeList().add(map);
                        break;
                    }
                }
                //如果循环出来flag还是false；说明该条信息第一次添加
                //如果是true则说明之前已经操作过了；
                if(!flag){
                    AssignmentVo assignmentVo = new AssignmentVo();
                    assignmentVo.setUid(assignment1.getUserId());
                    assignmentVo.setName(assignment1.getName());

                    List<Map> list1 = new ArrayList<>();
                    Map map = new HashMap();
                    map.put("workname",assignment1.getAssignmentName());
                    map.put("id",assignment1.getAssignmentId());
                    map.put("isComplete",assignment1.getStatus());
                    list1.add(map);
                    assignmentVo.setPracticeList(list1);

                    list.add(assignmentVo);
                }
            }
        }
        return list;
    }

    @Override
    public boolean addWork(AssignmentDto assignmentDto) {
        int result = workMapper.addWork(assignmentDto);
        return result>0;
    }

    @Override
    public List<Map> findNotWorkByTime(WorkDto workDto) {
        List<Assignment> list =  workMapper.findNotWorkByTime(workDto);
        //创建一个集合，用来存储返回的数据
        List<Map> list1= new ArrayList<>();
        for (Assignment assignment : list) {
            Integer userId = assignment.getUserId();
            //判断该用户是否已经添加到数组中了
            boolean flag= false;
            for (Map map : list1) {
                Integer userId1 = (Integer) map.get("userId");
                if(userId1!=null&&userId==userId1){
                    //说明该用户已经添加过了，判断该用户的是的作业完成情况
                    if(assignment.getStatus()==1){
                        Integer count = (Integer) map.get("count");
                        map.put("count",count+1);
                        flag = true;
                        break;
                    }
                }
            }
            //如果循序结束flag还是false。那么需要添加一个记录
           if(!flag){
               Map map = new HashMap();
               map.put("name",assignment.getName());
               if(assignment.getStatus()==1){
                   //如果状态没有交作业，就给count加一
                   map.put("count",1);
               }else{
                   map.put("count",0);
               }
               map.put("userId",assignment.getUserId());
               list1.add(map);
           }
        }
        return list1;
    }
}
