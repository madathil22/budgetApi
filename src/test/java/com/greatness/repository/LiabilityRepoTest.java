package com.greatness.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

import com.greatness.BaseTest;
import com.greatness.dto.LiabilityDTO;

public class LiabilityRepoTest extends BaseTest{

	@Autowired
	private LiabilityRepo repo;
	
	@Test
	public void testInsertstoLiability() {
		LiabilityDTO dto=new LiabilityDTO("testname","testdesc");
		repo.save(dto);
		
		
		
		LiabilityDTO dtofromdb=repo.findByName("testname");
		assertNotNull("Record to be present", dtofromdb);
		
		dtofromdb=repo.findByName("testname2");
		assertNull("Record NOT to be present", dtofromdb);
	}
}
