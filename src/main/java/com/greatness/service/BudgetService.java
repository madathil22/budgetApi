package com.greatness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatness.entity.liability.LiabilityEntity;
import com.greatness.entity.liability.LiabilityRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetService {

	private final LiabilityRepo repoLiab;
	
	public void saveliability(LiabilityEntity entity) {
		repoLiab.save(entity);
	}
	
	public List<LiabilityEntity> getAllLiability(){
		return (List<LiabilityEntity>)repoLiab.findAll();
	}
	
	public void deleteliability(Long id) {
		repoLiab.deleteById(id);
	}
	
	public LiabilityEntity findLiabilityById(Long id){
		return repoLiab.findById(id).get();
	}
}
