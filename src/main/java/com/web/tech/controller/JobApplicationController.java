package com.web.tech.controller;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Collate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web.tech.model.JobApplicationDetails;
import com.web.tech.model.JobseekerInfo;
import com.web.tech.repository.Readonlydata;
import com.web.tech.service.JobApplicationService;

@RestController
@RequestMapping("/api/jobapplications")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private Readonlydata readonlydata;
    
    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(
        @RequestParam Long jobseekerId,
        @RequestParam Long postId
    ) {
    	System.err.println("jid \t"+jobseekerId +"\tpost id "+ postId);
        boolean alreadyApplied = jobApplicationService.applyForJob(jobseekerId, postId);

        if (alreadyApplied) {
            return ResponseEntity.ok("You have already applied for this job.");
        }

        return ResponseEntity.ok("Job application submitted successfully!");
    }
    
    
    @GetMapping("/jobseeker/{jobseekerId}")
    public List<JobApplicationDetails> getApplicationsByJobseeker(@PathVariable Long jobseekerId) {
     
    	List<JobApplicationDetails> applicationDetails = readonlydata.findByJobseekerId(jobseekerId);
    	Collections.reverse(applicationDetails);
    	return applicationDetails;
    }
    
    
//    @GetMapping("/data")
//    public List<JobApplicationDetails> getdata()
//    {
//    	long
//    return 	(List<JobApplicationDetails>) readonlydata.findByJobseekerId(1);
//    }
}
  
    //-------------
