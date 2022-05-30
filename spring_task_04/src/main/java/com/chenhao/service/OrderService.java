package com.chenhao.service;

import com.chenhao.domain.Order;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderService {
    /**
     * 新增订单
     * @param order
     */
    public void addOrder(Order order);
}
