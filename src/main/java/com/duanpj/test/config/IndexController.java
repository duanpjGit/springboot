package com.duanpj.test.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanpj.test.base.BaseController;

@Controller
public class IndexController extends BaseController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:swagger-ui.html";
	}

}
