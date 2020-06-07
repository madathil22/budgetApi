package com.greatness.entity.liability;

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
public class LiabilityEntity implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Long id;

@NonNull
private String name;

@NonNull
private String description;

@NonNull
private Long amount;

}
