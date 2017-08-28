package com.duanpj.test.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanpj.test.base.RestHttpClient;
import com.duanpj.test.config.Constants;
import com.duanpj.test.service.MsgService;

@SuppressWarnings("unchecked")
@Service("msgService")
public class MsgServiceImpl implements MsgService {

	@Autowired
	private RestHttpClient restHttpClient;

	@Override
	public Map<String, Object> testMsg(Map<String, Object> reqBody) {
		String url = "http://API-SERVICE/sms/sendMsg?mobile={mobile}&msg={msg}&password={password}";
		Map<String, Object> map = restHttpClient.post(url, reqBody, Map.class, new Object[] { "15652343302", "测试", Constants.SMS_PASSWORD });
		return map;
	}

}
