package com.greatness.entity.liability;

import org.springframework.data.repository.CrudRepository;

public interface LiabilityRepo extends CrudRepository<LiabilityEntity, Long> {
	
	LiabilityEntity findByName(String name);

}
