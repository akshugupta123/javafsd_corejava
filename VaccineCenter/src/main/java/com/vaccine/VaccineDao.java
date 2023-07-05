package com.vaccine;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class VaccineDao {

@Autowired
Repoclass arepos;

@Autowired
Vrepclass vrepos;

@Autowired
Crepclass crepos;

@Autowired
Citirepclass citirepos;
public Admin  insertadm(Admin am) {
	return arepos.save(am);
	
}

public int login(String aname, String pass) {
	// TODO Auto-generated method stub
	int value=0;
	List<Admin> us = arepos.findAll();
	for(Admin adm:us) {
		String name=adm.getUname();
		String upass=adm.getUpass();
		
		if(name.equals(aname)&&upass.equals(pass)){
			value=1;
			return value;
		}
		
	}
	return value ;
}


//Vaccine Crud
public Vaccenter insertcent(Vaccenter vc) {
	return vrepos.save(vc);
}
public List<Vaccenter> getcent() {
	return vrepos.findAll();
}

public Vaccenter findbyid(int id) {
	Vaccenter vcent = vrepos.findById(id).get();
	return vcent;
}


public Vaccenter update(int id) {
	Vaccenter vcent = vrepos.findById(id).get();
	return vcent ;
	
}

public Vaccenter updatedet(Vaccenter vc) {
	
	return vrepos.save(vc);
}

public void deletecent(int id) {
   vrepos.deleteById(id);
}


// Vaccine and citizen jpl
public List<Citizens> findbyclinicname(String clinicname) {
	List<Citizens> citzn=citirepos.findbyclinicname(clinicname);
	return citzn;
	
}
public void deletebycname(String clinicname) {
	citirepos.deleteByName(clinicname);
}

public void updateByName(String newclinicname,String prevclinicname) {
	citirepos.updateByName(newclinicname, prevclinicname);
}
//Vacctiy
public List<City>getcity(){
	return crepos.findAll();
}
//Citizens
public Citizens insertciti(Citizens citi) {
	return citirepos.save(citi);
}

public List<Citizens> getciti(){
	return citirepos.findAll();	
}

public Citizens getcitibyid(int id){
Citizens citz = citirepos.findById(id).get();
return citz;	
}

public Citizens updatecitz(Citizens citz) {
	return citirepos.save(citz);
}



public void deleteciti(int id) {
   citirepos.deleteById(id);
}

	
}
