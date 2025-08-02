package com.example.mpdemo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from t_user")
    public List<User> search();
    @Insert("insert into t_user values(#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "orders",javaType = List.class,
            many=@Many(select = "com.example.mpdemo.mapper.OrderMapper.searchByUserId"))
    })
    List<User> selectAllUserAndOrders();
}
