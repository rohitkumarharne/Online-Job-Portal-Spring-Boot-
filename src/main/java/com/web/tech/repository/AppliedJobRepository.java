package com.web.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.tech.model.AppliedJob;
import java.util.List;

@Repository
public interface AppliedJobRepository extends JpaRepository<AppliedJob, Integer> {
    List<AppliedJob> findByEmployerId(int employerId);
}
