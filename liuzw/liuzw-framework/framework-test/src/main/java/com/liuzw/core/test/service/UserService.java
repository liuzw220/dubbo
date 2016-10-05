package com.liuzw.core.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuzw.core.mapper.threadlocal.DynamicColumnThreadLocal;
import com.liuzw.core.test.mapper.UserMapper;
import com.liuzw.core.test.pojo.User;

@Service
public class UserService {
    @Autowired
   private UserMapper userMapper;
    
    public List<User> queryByName(){
        User record=new User();
        record.setUsername("liuzhiwei");
        //id, username, password, phone, email, created, updated
        DynamicColumnThreadLocal.set("id,username,phone,email");//动态查询
        return userMapper.select(record);
        //return userMapper.select(record);
    }
}
