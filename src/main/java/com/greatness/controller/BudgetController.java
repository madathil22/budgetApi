package com.greatness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatness.dto.liability.LiabilityEntity;
import com.greatness.service.BudgetService;
import com.greatness.vo.StatusVO;

@RestController
@RequestMapping("/budget")
public class BudgetController {

	@Autowired
	private BudgetService service;
	
	@RequestMapping("/saveliability")
	public StatusVO saveliability(@RequestParam String name, @RequestParam String description, @RequestParam Long value) {
		service.saveliability(name, description, value);
		return new StatusVO(HttpStatus.OK, "SAVE success");
	}
	
	@RequestMapping("/deleteliability")
	public StatusVO deleteliability(@RequestParam Long id) {
		service.deleteliability(id);
		return new StatusVO(HttpStatus.OK, "DELETE success");
	}
	
	@RequestMapping("/getAllLiability")
	public List<LiabilityEntity> getAllLiability(){
		return service.getAllLiability();
	}
	
	
}
