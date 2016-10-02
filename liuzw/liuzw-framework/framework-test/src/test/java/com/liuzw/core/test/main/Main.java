package com.liuzw.core.test.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuzw.core.test.service.TestService;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:spring-much/applicationContext*.xml");
		context.start();
		TestService testService=context.getBean(TestService.class);
		System.out.println("\n \n \n \n");
		testService.querybyId();
		System.out.println("\n \n \n");
		testService.save();;
		System.out.println("加载成功");

	}

}
