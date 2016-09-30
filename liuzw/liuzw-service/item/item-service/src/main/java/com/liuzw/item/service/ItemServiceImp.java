package com.liuzw.item.service;

import org.springframework.stereotype.Service;

import com.liuzw.item.apis.ItemService;


@Service("itemService")
public class ItemServiceImp implements ItemService {

	public Integer save() {
		System.out.println("com.liuzw.item.service.ItemServiceImp执行save......");
		return 1;
	}

	@Override
	public Integer update() {
		System.out.println("com.liuzw.item.service.ItemServiceImp执行update......");
		return 1;
	}

	@Override
	public Integer delete() {
		System.out.println("com.liuzw.item.service.ItemServiceImp执行delete......");
		return 1;
	}

}
