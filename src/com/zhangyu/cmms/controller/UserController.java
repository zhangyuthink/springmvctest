package com.zhangyu.cmms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangyu.cmms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value="/login")
	public String login(Model model) {
		model.addAttribute("message","login from index");
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		model.addAttribute("message","logout from index");
		return "logout";
	}
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin(Model model,HttpServletRequest req,HttpServletResponse resp) {
		UserService userService=new UserService();
		if (userService.checkLogin(req.getParameter("userID"), req.getParameter("passWord"))) {
			model.addAttribute("statusCode","0");
		}else {
			model.addAttribute("userID", req.getParameter("userID"));
			model.addAttribute("statusCode","-1");
			return "login";
		}
		return "main";
	}
	
}