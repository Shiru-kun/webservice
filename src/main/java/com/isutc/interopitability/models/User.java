package com.isutc.interopitability.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.isutc.interopitability.modelEnum.Result;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Result name;
	private Result bi;
	@Enumerated
	private Result result; 
	@ManyToOne
	private Institution institution;
	

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Result getName() {
		return name;
	}
	public void setName(Result name) {
		this.name = name;
	}
	public Result getBi() {
		return bi;
	}
	public void setBi(Result bi) {
		this.bi = bi;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	
}
