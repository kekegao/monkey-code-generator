package com.monkey.ams.service.impl;

import com.monkey.ams.entity.Order;
import com.monkey.ams.mapper.OrderMapper;
import com.monkey.ams.service.OrderService;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author gkk
 * @since 2026-08-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
