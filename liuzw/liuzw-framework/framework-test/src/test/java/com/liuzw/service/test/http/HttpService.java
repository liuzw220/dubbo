package com.liuzw.service.test.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuzw.service.http.HttpClientService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration ({"/spring-http/app*.xml"}) //加载配置文件
public class HttpService {

	@Autowired
	private HttpClientService httpClientService;

	@Test
	public void doGet() throws Exception{
		System.out.println("加载成功");
		httpClientService.doGet("http://www.taobao.com/");
	}
}
