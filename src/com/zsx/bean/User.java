package com.zsx.bean;


public class User {
	private Integer id;
	private Integer number;
	private String name;
	private String sex;
	private String birthday;
	private String address;


	public User(Integer id, Integer number,String name,String sex,String birthday,String address) {
		super();
		this.id = id;
		this.number=number;
		this.name=name;
		this.sex=sex;
		this.birthday=birthday;
		this.address=address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
