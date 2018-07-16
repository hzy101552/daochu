package com.hzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.dao.UserDao;
import com.hzy.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserDeviceForExcel(User user) {
		// TODO Auto-generated method stub
		List<User> list = userDao.getUserForExcel(user);
		return list;
	}
	
	@Override
	public List<User> getUserDeviceFor() {
		// TODO Auto-generated method stub
		List<User> list = userDao.getUserFor();
		return list;
	}
	
	@Override
	public User getUserDevice() {
		// TODO Auto-generated method stub
		User list = userDao.getUser();
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("111");
		userDao.addUser(user);
	}

}
