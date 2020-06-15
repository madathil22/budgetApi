package com.greatness.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class CreateUpdateAuditEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@CreatedBy
	private String createdby;

	@JsonIgnore
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date createdon;

	@JsonIgnore
	@LastModifiedBy
	private String updatedby;

	@JsonIgnore
	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	private Date updatedon;

}
