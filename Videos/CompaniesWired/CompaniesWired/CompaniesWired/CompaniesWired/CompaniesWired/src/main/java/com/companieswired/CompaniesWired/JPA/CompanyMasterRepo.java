package com.companieswired.CompaniesWired.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.companieswired.CompaniesWired.Domain.CompanyMaster;

@Repository
public interface CompanyMasterRepo extends JpaRepository<CompanyMaster, String> {

	
	@Query(value="SELECT cin,company_name,registered_address,company_status FROM company_master where company_name LIKE %:data%",nativeQuery = true)
	List<CompanyMaster> getCompanyDetails(@Param("data") String data) throws Exception;
	
	@Query(value="select company_name from company_master where cin = :cin",nativeQuery = true)
	String getCompanyName(@Param("cin") String cin)throws Exception;
}
