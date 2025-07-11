package com.tushar.spring_boot_rest.service;

import com.tushar.spring_boot_rest.model.JobPost;
import com.tushar.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int postId) {
           repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Backend developer role", 2, Arrays.asList("Java", "JavaScript")),
                new JobPost(2, "Frontend Developer", "React and UI development", 1, Arrays.asList("JavaScript", "React")),
                new JobPost(3, "Data Analyst", "Analyze and visualize data", 3, Arrays.asList("Python", "SQL", "Tableau")),
                new JobPost(4, "DevOps Engineer", "CI/CD pipelines and cloud infra", 2, Arrays.asList("AWS", "Docker", "Kubernetes")),
                new JobPost(5, "Android Developer", "Mobile app development", 1, Arrays.asList("Java", "Kotlin", "XML"))
        ));repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
