package com.example.mpdemo.mapper;

import com.example.mpdemo.entity.Order;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from t_order where uid=#{uid}")
    List<Order> selectByUid(int uid);

    @Select("select * from t_order")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one = @One(select = "com.example.mpdemo.mapper.UserMapper.selectById")
            ),
    })
    List<Order> selectAllOrdersAndUser();
}
