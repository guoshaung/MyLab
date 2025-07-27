package com.example.mpdemo.entity;

import java.util.Date;

public class Order {
    private int id;
    private Date ordertime;
    private double total;
    //代表当前订单从属于哪一个客户
    private User user;
}