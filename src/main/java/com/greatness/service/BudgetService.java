package com.greatness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatness.dto.LiabilityDTO;
import com.greatness.repository.LiabilityRepo;

@Service
public class BudgetService {

	@Autowired
	private LiabilityRepo repoLiab;
	
	public void saveliability(String name, String value) {
		LiabilityDTO dto=new LiabilityDTO(name,value);
		repoLiab.save(dto);
	}
	
	public List<LiabilityDTO> getAllLiability(){
		return (List<LiabilityDTO>)repoLiab.findAll();
	}
	
	public void deleteliability(Long id) {
		repoLiab.deleteById(id);
	}
}
