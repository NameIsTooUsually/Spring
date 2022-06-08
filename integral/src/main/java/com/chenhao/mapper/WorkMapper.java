package com.chenhao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhao.domain.Assignment;
import com.chenhao.domain.AssignmentDto;
import com.chenhao.domain.WorkDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkMapper extends BaseMapper<Assignment> {

    List<Assignment> showWorksByCondition(WorkDto workDto);


    int addWork(AssignmentDto assignmentDto);

    List<Assignment> findNotWorkByTime(WorkDto workDto);
}
