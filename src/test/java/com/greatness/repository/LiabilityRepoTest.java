package com.greatness.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.greatness.BaseTest;
import com.greatness.entity.liability.LiabilityEntity;
import com.greatness.entity.liability.LiabilityRepo;

@Transactional
public class LiabilityRepoTest extends BaseTest{

	@Autowired
	private LiabilityRepo repo;
	
	@Test
	public void testInsertstoLiability() {
		LiabilityEntity dto=new LiabilityEntity("testname","testdesc",500L);
		repo.save(dto);
		
		
		
		LiabilityEntity dtofromdb=repo.findByName("testname");
		assertNotNull("Record to be present", dtofromdb);
		
		dtofromdb=repo.findByName("testname2");
		assertNull("Record NOT to be present", dtofromdb);
	}
}
