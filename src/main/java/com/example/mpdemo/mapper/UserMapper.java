package com.example.mpdemo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user")
    public List<User> search();
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
}
