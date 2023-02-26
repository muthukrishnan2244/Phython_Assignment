package com.companieswired.CompaniesWired.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companieswired.CompaniesWired.Domain.CompanyMaster;
import com.companieswired.CompaniesWired.Response.DirectorDetailsResponse;
import com.companieswired.CompaniesWired.Service.Companyservice;

@RestController
public class CompanyController {

	@Autowired
	private Companyservice companyservice;
	
	
	@GetMapping("/company")
	public ResponseEntity<List<CompanyMaster>> companydetails(@RequestParam("data") String data) throws Exception {
		List<CompanyMaster> list = new  ArrayList<>();
		try {
			 list = companyservice.companyDetails(data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/directors")
	public ResponseEntity<List<DirectorDetailsResponse>> directorsDetails(@RequestParam("data") String data)throws Exception{
		List<DirectorDetailsResponse> directors = new ArrayList<DirectorDetailsResponse>();
		try {
			System.out.println(data);
			//directors = companyservice.getDirectorsDetails(data);
			directors = companyservice.getDirectors(data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(directors);
	}
}
