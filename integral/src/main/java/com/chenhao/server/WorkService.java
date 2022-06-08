package com.chenhao.server;

import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentDto;
import com.chenhao.domain.AssignmentVo;
import com.chenhao.domain.WorkDto;

import java.util.List;
import java.util.Map;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:37
 */
public interface WorkService {
    List<AssignmentVo> showWorksByCondition(WorkDto workDto);

    boolean addWork(AssignmentDto assignmentDto);

    List<Map> findNotWorkByTime(WorkDto workDto);
}
