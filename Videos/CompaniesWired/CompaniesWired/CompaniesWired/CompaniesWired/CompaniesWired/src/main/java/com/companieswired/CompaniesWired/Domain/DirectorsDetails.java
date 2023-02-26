package com.companieswired.CompaniesWired.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="directors_signatory_details")
public class DirectorsDetails {

	@Id
	@Column(name="din_pan")
	private String din_pan;
	
	@Column(name="full_name")
	private String full_name;

	

	public String getDin_pan() {
		return din_pan;
	}

	public void setDin_pan(String din_pan) {
		this.din_pan = din_pan;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public DirectorsDetails() {
		super();
	}

	public DirectorsDetails(String din_pan, String full_name) {
		super();
		this.din_pan = din_pan;
		this.full_name = full_name;
	}
	
	
	
}
