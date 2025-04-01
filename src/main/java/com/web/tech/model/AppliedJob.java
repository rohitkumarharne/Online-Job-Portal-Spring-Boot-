package com.web.tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable  // ✅ Makes the entity read-only
@Table(name = "appliedjob")
public class AppliedJob {

    @Id
    private int id;

    private String status;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "jobseeker_id")
    private int jobseekerId;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String education;

    @Column(name = "portfolio_url")
    private String portfolioUrl;

    private String skills;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "employer_id")
    private int employerId;

    // Constructor
    public AppliedJob() {}

    // Getters only (No setters, making it read-only)
    public int getId() { return id; }
    public String getStatus() { return status; }
    public int getPostId() { return postId; }
    public int getJobseekerId() { return jobseekerId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEducation() { return education; }
    public String getPortfolioUrl() { return portfolioUrl; }
    public String getSkills() { return skills; }
    public String getJobTitle() { return jobTitle; }
    public int getEmployerId() { return employerId; }

    // toString Method
    @Override
    public String toString() {
        return "AppliedJob{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", postId=" + postId +
                ", jobseekerId=" + jobseekerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", education='" + education + '\'' +
                ", portfolioUrl='" + portfolioUrl + '\'' +
                ", skills='" + skills + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employerId=" + employerId +
                '}';
    }
}
