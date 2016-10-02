package com.liuzw.core.test.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private static final Log LOGGER = LogFactory.getLog(TestService.class);

	public void querybyId(){
		LOGGER.info("执行com.liuzw.core.test.service.TestService.querybyId 方法.看日志应该输出读库");
	}
	public void save(){
		LOGGER.info("执行com.liuzw.core.test.service.TestService.save 方法.看日志应该输出写库");
	}

}
