package com.example.mpdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user")
    public List query(){
        List<User> list = userMapper.selectList(null); // 查询所有用户
        System.out.println( list);
        return list;
    }
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("username","lucy");
        return userMapper.selectList(queryWrapper);
    }
    @PostMapping("/user")
    public String save(User user){
        int i=userMapper.insert(user);
        if(i>0)
        {
//            System.out.println("插入成功");
            return "插入成功";
        }
        else{
//            System.out.println("插入失败");
            return "插入失败";
        }
    }
}
