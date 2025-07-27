package com.example.mpdemo.controller;

import com.example.mpdemo.entity.Order;
import com.example.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @GetMapping("order")
    public List<Order> find(){
        return orderMapper.findAll();
    }
}
