package com.chenhao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhao.domain.Assignment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkMapper extends BaseMapper<Assignment> {

    List<Assignment> showWorksByCondition();

}
