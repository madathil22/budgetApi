package com.greatness.vo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusVO {
	private HttpStatus status;
	private String description;
}
