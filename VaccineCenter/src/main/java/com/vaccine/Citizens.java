package com.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

public class Citizens {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String clinicname;
    private int noofdose;
    private String Status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClinicname() {
		return clinicname;
	}
	public void setClinicname(String clinicname) {
		this.clinicname = clinicname;
	}
	public int getNoofdose() {
		return noofdose;
	}
	public void setNoofdose(int noofdose) {
		this.noofdose = noofdose;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
    
}
