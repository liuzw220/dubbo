package com.liuzw.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuzw.item.apis.ItemService;

@Service
public class ItemLocalService {
	
	@Autowired
	private ItemService itemService;
	
	public Integer save(){
		return itemService.save();
	}

}
