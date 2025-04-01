package com.web.tech.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.web.tech.model.JobApplication;
import com.web.tech.model.JobseekerInfo;
import com.web.tech.model.Post;
import com.web.tech.repository.JobApplicationRepository;
import com.web.tech.repository.JobseekerInfoRepository;
import com.web.tech.repository.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobseekerInfoRepository jobseekerRepository;

    @Autowired
    private PostRepository postRepository;

    public boolean applyForJob(Long jobseekerId, Long postId) {
        Optional<JobseekerInfo> jobseekerOpt = jobseekerRepository.findById(jobseekerId);
        Optional<Post> postOpt = postRepository.findById(postId);

        if (jobseekerOpt.isPresent() && postOpt.isPresent()) {
            JobseekerInfo jobseeker = jobseekerOpt.get();
            Post post = postOpt.get();

            // Check if the job application already exists
            if (jobApplicationRepository.existsByJobseekerAndJobPost(jobseeker, post)) {
                return true; // Already applied
            }

            JobApplication jobApplication = new JobApplication(jobseeker, post, "Applied");
            jobApplicationRepository.save(jobApplication);
            return false; // Successfully applied
        }
        return false; // Invalid jobseeker ID or post ID
    }
    
    //----------------------------
    
  
    
    //---------------------------
    
   
    
}
