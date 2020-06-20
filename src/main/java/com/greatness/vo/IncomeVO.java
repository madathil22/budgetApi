package com.greatness.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeVO {
	private Long id;
	private String source;
	private Date incomedate;
	private Long income;
	private boolean modified;
}
