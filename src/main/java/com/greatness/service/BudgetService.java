package com.greatness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatness.entity.income.IncomeEntity;
import com.greatness.entity.income.IncomeRepo;
import com.greatness.entity.liability.LiabilityEntity;
import com.greatness.entity.liability.LiabilityRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetService {

	private final LiabilityRepo repoLiab;
	private final IncomeRepo repoIncome;
	
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
	
	public void saveincome(IncomeEntity entity) {
		repoIncome.save(entity);
	}
	
	public List<IncomeEntity> getAllIncome(){
		return (List<IncomeEntity>)repoIncome.findAll();
	}
	
	public void deleteincome(Long id) {
		repoIncome.deleteById(id);
	}
	
	public IncomeEntity findIncomeById(Long id){
		return repoIncome.findById(id).get();
	}
	
	
}
