package com.min.edu.vo;

import java.io.Serializable;
import java.util.Arrays;

public class MemberVo implements Serializable {
	
	private static final long serialVersionUID = -3999632666229659407L;
	
	private int seq;
	private String name;
	private String id;
	private String password;
	private String phone;
	private String address;
	private String birth;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVo(int seq, String name, String id, String password, String phone, String address, String birth) {
		super();
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "MemberVo [seq=" + seq + ", name=" + name + ", id=" + id + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + ", birth=" + birth + "]";
	}
	
}
