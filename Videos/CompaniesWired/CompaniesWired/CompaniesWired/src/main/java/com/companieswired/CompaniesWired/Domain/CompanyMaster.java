package com.companieswired.CompaniesWired.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_master")
public class CompanyMaster {
	
	
	@Id
	@Column(name="cin")
	private String cin;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="registered_address")
	private String address;
	
	@Column(name="company_status")
	private String company_status;
	
	
	

	public String getCompany_status() {
		return company_status;
	}

	public void setCompany_status(String company_status) {
		this.company_status = company_status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public CompanyMaster(String cin, String companyName, String address, String company_status) {
		super();
		this.cin = cin;
		this.companyName = companyName;
		this.address = address;
		this.company_status = company_status;
	}


	public CompanyMaster() {
		
	}
	
	
}
