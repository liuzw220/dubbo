package com.liuzw.core.test.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuzw.core.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration ({"/spring-mybatis/app*.xml"}) //加载配置文件
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testQueryAll(){
        System.out.println("加载成功");
        userService.queryByName();
        
    }

}
