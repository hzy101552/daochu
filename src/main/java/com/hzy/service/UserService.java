package com.hzy.service;

import java.util.List;

import com.hzy.pojo.User;


public interface UserService {

	public List<User> getUserDeviceForExcel(User user);

	public List<User> getUserDeviceFor();
	
	public User getUserDevice();
	
	public void addUser(User user);
}
