package com.companieswired.CompaniesWired.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.companieswired.CompaniesWired.Domain.DirectorsLink;
import com.companieswired.CompaniesWired.Response.DirectorDetailsResponse;
import com.companieswired.CompaniesWired.Response.DirectorsDetals;


@Repository
public interface DirectorLink extends JpaRepository<DirectorsLink,String> {

	
	@Query(value="SELECT company_id,director_id FROM company_director_link where director_id = :data",nativeQuery = true)
	List<DirectorsLink> getDirectorLink(@Param("data") String data)throws Exception;
	
	
	@Query(value="SELECT d.din_pan,d.full_name,(SELECT DISTINCT company_name from company_master where cin = company_id) FROM directors_signatory_details d inner JOIN company_director_link on d.din_pan = director_id where d.full_name LIKE %:data%",nativeQuery = true)
	List<String> getDirectors(@Param("data") String data) throws Exception;
}
