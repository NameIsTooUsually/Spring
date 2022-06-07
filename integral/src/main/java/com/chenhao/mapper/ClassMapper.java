package com.chenhao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhao.domain.KsClass;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 12:49
 */
@Mapper
public interface ClassMapper extends BaseMapper<KsClass> {
}
