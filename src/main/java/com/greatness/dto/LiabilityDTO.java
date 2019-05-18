package com.greatness.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name="BUDGET_LIABILITY")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LiabilityDTO implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private long id;

@NonNull
private String name;

@NonNull
private String description;

}
