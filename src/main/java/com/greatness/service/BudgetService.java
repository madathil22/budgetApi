package com.greatness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatness.dto.liability.LiabilityEntity;
import com.greatness.dto.liability.LiabilityRepo;

@Service
public class BudgetService {

	@Autowired
	private LiabilityRepo repoLiab;
	
	public void saveliability(String name, String description,Long value) {
		LiabilityEntity dto=new LiabilityEntity(name,description,value);
		repoLiab.save(dto);
	}
	
	public List<LiabilityEntity> getAllLiability(){
		return (List<LiabilityEntity>)repoLiab.findAll();
	}
	
	public void deleteliability(Long id) {
		repoLiab.deleteById(id);
	}
}
