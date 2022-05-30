package com.chenhao.service.impl;

import com.chenhao.domain.Equipment;
import com.chenhao.domain.Order;
import com.chenhao.mapper.OrderMapper;
import com.chenhao.service.EquipmentService;
import com.chenhao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 下订单并减库存
     * @param order
     */


    public void addOrder(Order order) {
        //1.下订单
        orderMapper.insert(order);
        //2.减少库存
        Equipment equipment = new Equipment();
        equipment.setStock(order.getNum());
        equipment.setId(order.getEquipmentId());
        //equipment.setCreated(new Date());
        //equipment.setUpdated(new Date());
        equipmentService.reduceStock(equipment);
    }
}
