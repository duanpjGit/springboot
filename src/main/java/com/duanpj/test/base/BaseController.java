package com.duanpj.test.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class BaseController {

	/**
	 * 输出内容的简便函数.
	 */
	protected void render(HttpServletResponse response, String text, String contentType) {
		try {
			response.setContentType(contentType);
			if (null != text) {
				response.getWriter().write(text);
			}
		} catch (IOException e) {
			RecordLog.printLog(e.getMessage());
		}
	}

	/**
	 * 直接输出字符串,编码为UTF-8.
	 */
	protected void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出JSON,编码为UTF-8.
	 */
	protected void renderJson(HttpServletResponse response, Object obj) {
		render(response, JSONObject.toJSONString(obj), "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出HTML,编码为UTF-8.
	 */
	protected void renderHtml(HttpServletResponse response, String html) {
		render(response, html, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出XML,编码为UTF-8.
	 */
	protected void renderXML(HttpServletResponse response, String xml) {
		render(response, xml, "text/xml;charset=UTF-8");
	}

}
