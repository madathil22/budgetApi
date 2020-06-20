package com.greatness.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatness.entity.income.IncomeEntity;
import com.greatness.entity.liability.LiabilityEntity;
import com.greatness.service.BudgetService;
import com.greatness.vo.IncomeVO;
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
	public StatusVO deleteliability(@RequestParam(value = "recId", required = true) Long recId) {
		service.deleteliability(recId);
		return new StatusVO(HttpStatus.OK, "DELETE success");
	}
	@PostMapping("/updateliability")
	public StatusVO updateliability(@RequestBody List<LiabilityVO> liabilities) {
		liabilities.forEach(liability -> {
			service.saveliability(this.convertToEntity_Liabilty(liability));
		});
		return new StatusVO(HttpStatus.OK, "SAVE success");
	}

	@GetMapping("/getAllLiability")
	public List<LiabilityVO> getAllLiability() {
		return service.getAllLiability().stream().map(this::convertToVo_Liability).collect(Collectors.toList());
	}

	private LiabilityVO convertToVo_Liability(LiabilityEntity entity) {
		LiabilityVO vo = new LiabilityVO(entity.getId(), entity.getName(), entity.getDescription(), entity.getAmount(),false);
		return vo;
	}

	private LiabilityEntity convertToEntity_Liabilty(LiabilityVO vo) {
		LiabilityEntity entity = new LiabilityEntity(vo.getId(), vo.getName(), vo.getDescription(), vo.getAmount());
		return entity;
	}

	@PostMapping("/saveincome")
	public StatusVO saveincome(@RequestBody IncomeVO incomereq) {
		service.saveincome(this.convertToEntity_Income(incomereq));
		return new StatusVO(HttpStatus.OK, "SAVE success");
	}

	@PostMapping("/updateincome")
	public StatusVO saveincome(@RequestBody List<IncomeVO> incomes) {
		incomes.forEach(income -> {
			service.saveincome(this.convertToEntity_Income(income));
		});
		return new StatusVO(HttpStatus.OK, "SAVE success");
	}

	@PostMapping("/deleteincome")
	public StatusVO deleteincome(@RequestParam(value = "recId", required = true) Long recId) {
		service.deleteincome(recId);
		return new StatusVO(HttpStatus.OK, "DELETE success");
	}

	@GetMapping("/getAllIncome")
	public List<IncomeVO> getAllIncome() {
		return service.getAllIncome().stream().map(this::convertToVo_Income).collect(Collectors.toList());
	}

	private IncomeVO convertToVo_Income(IncomeEntity entity) {
		IncomeVO vo = new IncomeVO(entity.getId(), entity.getSource(), entity.getIncomedate(), entity.getIncome(),
				false);
		return vo;
	}

	private IncomeEntity convertToEntity_Income(IncomeVO vo) {
		IncomeEntity entity = new IncomeEntity(vo.getId(), vo.getSource(), vo.getIncomedate(), vo.getIncome());
		return entity;
	}

}
