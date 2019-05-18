package com.greatness.repository;

import org.springframework.data.repository.CrudRepository;

import com.greatness.dto.LiabilityDTO;

public interface LiabilityRepo extends CrudRepository<LiabilityDTO, Long> {
	
	LiabilityDTO findByName(String name);

}
