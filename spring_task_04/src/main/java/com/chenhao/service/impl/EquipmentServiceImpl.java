package com.chenhao.service.impl;

import com.chenhao.domain.Equipment;
import com.chenhao.mapper.EquipmentMapper;
import com.chenhao.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 减少库存
     * @param equipment
     */
    public void reduceStock(Equipment equipment) {
        equipmentMapper.reduceStock(equipment);
    }

    /**
     * 添加装备信息
     * @param equipment
     */
    public void addEquipment(Equipment equipment) {
        equipmentMapper.insert(equipment);
    }
}
