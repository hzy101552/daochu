package com.hzy.dao;

import java.util.List;

import com.hzy.pojo.User;

public interface UserDao {

	List<User> getUserForExcel(User user);
	List<User> getUserFor();
	User getUser();
	void addUser(User user);
}
