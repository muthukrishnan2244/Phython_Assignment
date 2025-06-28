package com.companieswired.CompaniesWired.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.companieswired.CompaniesWired.Domain.DirectorsDetails;

@Repository
public interface DirectorsRepo extends JpaRepository<DirectorsDetails,String>{

	@Query(value="SELECT din_pan,full_name FROM directors_signatory_details where full_name like %:data%",nativeQuery = true)
	List<DirectorsDetails> getDirectorsDetails(@Param("data") String data) throws Exception;
}
