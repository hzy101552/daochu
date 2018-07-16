package com.hzy.pojo;

import java.util.Date;

public class User {
	private  Integer id;  
	private  String name;  
    private String sex;  
    private String age;
    private Date date;
    private String address;
    
	public User() {
	}
	
	public User(String name, String sex, String age, Date date, String address) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.date = date;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
}
