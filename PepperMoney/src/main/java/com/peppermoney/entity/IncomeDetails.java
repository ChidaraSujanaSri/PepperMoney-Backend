package com.peppermoney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="IncomeDetailsTable")

public class IncomeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="IncomeType")
	String incomeType;
	
	@Column(name="IncomeValue")
	double incomeValue;
	
	@Column(name="ExperienceYears")
	int selfYears;
	
	@Column(name="ExperienceMonths")
	int selfMonths;
	
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public double getIncomeValue() {
		return incomeValue;
	}
	public void setIncomeValue(double income) {
		this.incomeValue = income;
	}
	public Integer getSelfYears() {
		return selfYears;
	}
	public void setSelfYears(Integer selfYears) {
		this.selfYears = selfYears;
	}
	public Integer getSelfMonths() {
		return selfMonths;
	}
	public void setSelfMonths(Integer selfMonths) {
		this.selfMonths = selfMonths;
	}
	@Override
	public String toString() {
		return "HomeLoanForm [incomeType=" + incomeType + ", incomeValue=" + incomeValue + ", selfYears=" + selfYears
				+ ", selfMonths=" + selfMonths + "]";
	}
	public IncomeDetails() {
		super();
	}
	

}
