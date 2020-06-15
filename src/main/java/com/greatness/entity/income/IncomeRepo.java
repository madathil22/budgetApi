package com.greatness.entity.income;

import org.springframework.data.repository.CrudRepository;

public interface IncomeRepo extends CrudRepository<IncomeEntity, Long> {
	
	IncomeEntity findBySource(String source);

}
