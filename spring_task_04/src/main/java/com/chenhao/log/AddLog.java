package com.chenhao.log;

import com.chenhao.domain.Log;
import com.chenhao.mapper.AddLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddLog {

    @Autowired
    AddLogMapper addLogMapper;

    public void addLog(Log log){
        addLogMapper.addlog(log);
    }

}
