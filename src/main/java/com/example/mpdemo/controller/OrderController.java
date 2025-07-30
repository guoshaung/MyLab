package com.example.mpdemo.controller;

import com.example.mpdemo.entity.Order;
import com.example.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    // 保持原有的 /order 路径
    @GetMapping("order")
    public List<Order> find(){
        return orderMapper.selectAllOrdersAndUser();
    }

    // 添加新的 /order/findAll 路径映射
    @GetMapping("order/findAll")
    public List<Order> findAll(){
        return orderMapper.selectAllOrdersAndUser();
    }
}
