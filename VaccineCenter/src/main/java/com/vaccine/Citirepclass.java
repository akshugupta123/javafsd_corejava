package com.vaccine;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface Citirepclass extends JpaRepository<Citizens,Integer>{
    
	String query="select citizen from Citizens citizen where clinicname=?1";
	@Query(query)
	public List<Citizens> findbyclinicname(String clinicname);
	
	String query1="delete from Citizens citz where citz.clinicname=:clinicname";
	@Transactional 
	@Modifying
	@Query(query1)
	public void deleteByName(String clinicname);
	
	String query2="update Citizens Set clinicname=:newclinicname Where clinicname=:prevclinicname";
	@Transactional 
	@Modifying
	@Query(query2)
	public void updateByName(String newclinicname,String prevclinicname);
	
}
