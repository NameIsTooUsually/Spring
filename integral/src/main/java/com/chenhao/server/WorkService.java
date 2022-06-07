package com.chenhao.server;

import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentVo;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:37
 */
public interface WorkService {
    AssignmentVo showWorksByCondition(Assignment assignment);
}
