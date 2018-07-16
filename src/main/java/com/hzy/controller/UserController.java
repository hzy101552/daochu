package com.hzy.controller;

import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzy.pojo.User;
import com.hzy.service.ExportExcel;
import com.hzy.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/export")
	public void export(HttpServletRequest request, HttpServletResponse response/*,@RequestParam(value = "queryJson") String queryJson*/) throws Exception {
		//如果出现中文乱码请添加下面这句
		/*queryJson = URLDecoder.decode(queryJson,"utf-8"); 
		//需要导入alibaba的fastjson包
		User user = com.alibaba.fastjson.JSON.parseObject(queryJson, User.class);
		List<User> userlList = userService.getUserDeviceForExcel(user);*/
		List<User> userlList = userService.getUserDeviceFor();
		ExportExcel<User> ee= new ExportExcel<User>();
		String[] headers = { "序号", "姓名", "性别", "年龄","时间" };
		String fileName = "用户信息表";
		ee.exportExcel(headers,userlList,fileName,response);
	}
	
	@Test
	public void t() throws ParseException {
		String string = new String();
		string="2017-11-12";
		
		//System.out.println(date.parse(string));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf.parse(string);
		Date date = new java.sql.Date(date2.getTime());
		System.out.println(date);
	}
	
	@RequestMapping("/getUser")
	public String getU(HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession();
		User user = userService.getUserDevice();
		session.setAttribute("user", user);
		/*String string = new String();
		string="2017-11-12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf.parse(string);
		Date date = new java.sql.Date(date2.getTime());
		User user1 = new User("asd", "男", "22", date, "adsfaaf");
		userService.addUser(user1);
		System.out.println(date);*/
		return "/index";
	}
	
	@RequestMapping("/t")
	public String t(User user,HttpServletRequest request) throws ParseException {
		System.out.println("111");
		System.out.println(user.getName());
		
		return "/index";
	}

}
