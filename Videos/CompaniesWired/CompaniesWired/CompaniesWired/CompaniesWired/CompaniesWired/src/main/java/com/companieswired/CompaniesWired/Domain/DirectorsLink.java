package com.companieswired.CompaniesWired.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_director_link")
public class DirectorsLink {

	@Id
	@Column(name="director_id")
	private String director_id;
	
	@Column(name="company_id")
	private String company_id;

	public DirectorsLink() {
		super();
	}

	public String getDirector_id() {
		return director_id;
	}

	public void setDirector_id(String director_id) {
		this.director_id = director_id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	
	
	
}
