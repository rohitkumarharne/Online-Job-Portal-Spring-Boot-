package com.web.tech.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.tech.model.EmployerInfo;
import com.web.tech.model.JobseekerInfo;
import com.web.tech.model.User;
import com.web.tech.service.EmployerInfoService;
import com.web.tech.service.JobseekerInfoService;
import com.web.tech.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000/")
public class UserController {

    private final UserService service;
    private final JobseekerInfoService infoService;
    private final EmployerInfoService employerInfoService;
    public UserController(UserService service, JobseekerInfoService infoService,EmployerInfoService employerInfoService) {
        this.service = service;
        this.infoService=infoService;
        this.employerInfoService=employerInfoService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.saveUser(user);
        System.out.println(user.getRole());
        if("JOBSEEKER".equals(user.getRole().toString()))
        {
        	System.out.println("if Block");
        	 JobseekerInfo j = new JobseekerInfo();
             j.setUserId(user.getUserId());
             j.setFullName(user.getUsername());
             infoService.saveJobseekerInfo(j);	
             return ResponseEntity.ok(savedUser);
        }
        else
        {
        	EmployerInfo n = new EmployerInfo();
        	n.setUserId(user.getUserId());
        	n.setCompanyName(user.getUsername());
        	employerInfoService.createEmployerInfo(n);
        	 return ResponseEntity.ok(savedUser);
        }
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = service.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = service.getUserByUsername(username);
        System.out.println(user);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
