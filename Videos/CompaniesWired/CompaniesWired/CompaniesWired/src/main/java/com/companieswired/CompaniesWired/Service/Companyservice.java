package com.companieswired.CompaniesWired.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companieswired.CompaniesWired.Domain.CompanyMaster;
import com.companieswired.CompaniesWired.JPA.CompanyMasterRepo;
import com.companieswired.CompaniesWired.JPA.DirectorLink;
import com.companieswired.CompaniesWired.JPA.DirectorsRepo;
import com.companieswired.CompaniesWired.Response.DirectorDetailsResponse;
import com.companieswired.CompaniesWired.Response.DirectorsDetals;
import com.companieswired.CompaniesWired.Domain.DirectorsDetails;
import com.companieswired.CompaniesWired.Domain.DirectorsLink;

@Service
public class Companyservice {

	
	@Autowired
	private CompanyMasterRepo companyrepo;
	
	private DirectorsRepo directorsrepo;
	
	private DirectorLink directorlink;
	
	public Companyservice(DirectorsRepo directorsrepo,DirectorLink directorlink) {
		super();
		this.directorsrepo = directorsrepo;
		this.directorlink = directorlink;
	}


	public List<CompanyMaster> companyDetails(String data)throws Exception {
		List<CompanyMaster> details = new ArrayList<CompanyMaster>();
		try {
			System.out.println("====+++++++==="+data);
			 details = companyrepo.getCompanyDetails(data);
			for(CompanyMaster s : details) {
				System.out.println(s.getCin()+" "+s.getCompanyName()+" "+s.getCompany_status()+" "+s.getAddress());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	
	
	public List<DirectorDetailsResponse> getDirectorsDetails(String data)throws Exception{
		List<DirectorDetailsResponse> directors = new ArrayList<DirectorDetailsResponse>();
		try {
			List<DirectorsDetails> directorslist = directorsrepo.getDirectorsDetails(data);
			directorslist.forEach(e -> {
				String companyid = "";
				String companyname = "";
				DirectorDetailsResponse res = new DirectorDetailsResponse();
				res.setDin(e.getDin_pan());
				try {
					List<DirectorsLink> ddl_link = directorlink.getDirectorLink(res.getDin());
					for(DirectorsLink s : ddl_link) {
						companyid = s.getCompany_id();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				res.setDirector(e.getFull_name());
				try {
					 companyname = companyrepo.getCompanyName(companyid);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				res.setCompanyNmae(companyname);
				directors.add(res);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return directors;
	}
	
	public List<DirectorDetailsResponse> getDirectors(String data)throws Exception{
		List<DirectorDetailsResponse> directors = new ArrayList<DirectorDetailsResponse>();
	    try {
	    	List<String> ddl_link = directorlink.getDirectors(data);
			DirectorDetailsResponse res = new DirectorDetailsResponse();
	    	for(int i =0;i<ddl_link.size();i++) {
				res = new DirectorDetailsResponse();
				String[] values = ddl_link.get(i).toString().split(",");
				res.setDin(values[0].toString());
				res.setDirector(values[1].toString());
				res.setCompanyNmae(values[2].toString());
		    	directors.add(res);
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return directors;
	}
	
}
