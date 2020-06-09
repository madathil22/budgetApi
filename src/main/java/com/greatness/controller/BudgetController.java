package com.greatness.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatness.entity.liability.LiabilityEntity;
import com.greatness.service.BudgetService;
import com.greatness.vo.LiabilityVO;
import com.greatness.vo.StatusVO;

import lombok.RequiredArgsConstructor;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetController {

	private final BudgetService service;
	private final ModelMapper modelMapper;
	
	@PostMapping("/saveliability")
	public StatusVO saveliability(@RequestBody LiabilityVO liabilityreq) {
		service.saveliability(this.convertToEntity_Liabilty(liabilityreq));
		return new StatusVO(HttpStatus.OK, "SAVE success");
	}
	
	@PostMapping("/deleteliability")
	public StatusVO deleteliability(@RequestParam Long id) {
		service.deleteliability(id);
		return new StatusVO(HttpStatus.OK, "DELETE success");
	}
	
	@GetMapping("/getAllLiability")
	public List<LiabilityVO> getAllLiability(){
		return service.getAllLiability()
				.stream()
				.map(this::convertToVo_Liability)
				.collect(Collectors.toList());
	}
	
	private LiabilityVO convertToVo_Liability(LiabilityEntity entity) {
		LiabilityVO vo=modelMapper.map(entity, LiabilityVO.class);
		return vo;
	}
	
	private LiabilityEntity convertToEntity_Liabilty(LiabilityVO vo) {
		LiabilityEntity entity=modelMapper.map(vo,LiabilityEntity.class);
		return entity;
	}
	
	
	
}
