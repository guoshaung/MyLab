package com.example.mpdemo.controller;

import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/User")
    public List query(){
        List<User> list = userMapper.selectList(null); // 查询所有用户
        System.out.println( list);
        return list;
    }
    @PostMapping("/User")
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
