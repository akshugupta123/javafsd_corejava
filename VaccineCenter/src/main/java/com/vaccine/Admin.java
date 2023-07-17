package com.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

public class Admin {
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String uname;
	private String uemail;
	private String upass;
	
}
