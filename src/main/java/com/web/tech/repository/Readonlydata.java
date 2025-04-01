package com.web.tech.repository;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.web.tech.model.JobApplicationDetails;


public interface Readonlydata extends CrudRepository<JobApplicationDetails,Integer>{

	 List<JobApplicationDetails> findByJobseekerId(Long jobseekerId);
	 


}
