package com.chenhao.server.impl;

import com.chenhao.domain.KsClass;
import com.chenhao.mapper.ClassMapper;
import com.chenhao.server.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 12:56
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public List<KsClass> findAllClass() {
        List<KsClass> ksClasses = classMapper.selectList(null);
        return ksClasses;
    }
}
