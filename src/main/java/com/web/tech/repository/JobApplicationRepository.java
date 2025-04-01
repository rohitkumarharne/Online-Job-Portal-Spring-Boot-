package com.web.tech.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.tech.model.JobApplication;
import com.web.tech.model.JobApplicationDTO;
import com.web.tech.model.JobseekerInfo;
import com.web.tech.model.Post;

import jakarta.transaction.Transactional;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    boolean existsByJobseekerAndJobPost(JobseekerInfo jobseeker, Post jobPost);

    List<JobApplication> findByJobseeker(JobseekerInfo jobseeker); // Corrected method
    
    
    
    @Modifying
    @Transactional
    @Query("UPDATE JobApplication j SET j.status = :status WHERE j.jobPost.id = :postId AND j.jobseeker.id = :jobseekerId")
    int updateJobApplicationStatus(@Param("status") String status, @Param("postId") Long postId, @Param("jobseekerId") Long jobseekerId);

}
