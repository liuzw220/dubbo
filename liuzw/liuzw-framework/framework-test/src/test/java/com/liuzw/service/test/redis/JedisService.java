package com.liuzw.service.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuzw.service.redis.RedisService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration ({"/spring-redis/app*.xml"}) //加载配置文件
public class JedisService {

	@Autowired
	private RedisService redisService;

	@Test
	public void getByKey(){
		System.out.println("加载成功");
		System.out.println(redisService.get("ping"));
	}
}
