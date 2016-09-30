package com.liuzw.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuzw.manager.service.ItemLocalService;




@Controller
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	private ItemLocalService itemService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String Index(){
		System.out.println("com.liuzw.manager.controller.ItemController访问index。。。。");
		System.out.println("itemService="+itemService);
		Integer save = itemService.save();
		System.out.println("执行 save方法返回数据:"+save);
		return "NewFile";
	}

}
