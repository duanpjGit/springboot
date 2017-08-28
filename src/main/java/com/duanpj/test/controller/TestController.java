package com.duanpj.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duanpj.test.base.BaseController;
import com.duanpj.test.service.MsgService;

@RestController
public class TestController extends BaseController {

	@Autowired
	private MsgService msgService;

	@RequestMapping("sendMsg")
	public Map<String, Object> sendMsg() {
		Map<String, Object> reqMap = new HashMap<String, Object>();
		Map<String, Object> map = msgService.testMsg(reqMap);
		return map;
	}

}
