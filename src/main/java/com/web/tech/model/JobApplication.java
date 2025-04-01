package com.web.tech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jobseeker_id", nullable = false)
    private JobseekerInfo jobseeker;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post jobPost;

    private String status; // Example: "Pending", "Accepted", "Rejected"

    // Constructors
    public JobApplication() {}

    public JobApplication(JobseekerInfo jobseeker, Post jobPost, String status) {
        this.jobseeker = jobseeker;
        this.jobPost = jobPost;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobseekerInfo getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(JobseekerInfo jobseeker) {
        this.jobseeker = jobseeker;
    }

    public Post getJobPost() {
        return jobPost;
    }

    public void setJobPost(Post jobPost) {
        this.jobPost = jobPost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
