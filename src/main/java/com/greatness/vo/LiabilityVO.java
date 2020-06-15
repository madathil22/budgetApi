package com.greatness.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiabilityVO {
	private Long id;
	private String name;
	private String description;
	private Long amount;
}
