package com.tushar.JobApp.repo;

import com.tushar.JobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Backend developer role", 2, Arrays.asList("Java", "JavaScript")),
            new JobPost(2, "Frontend Developer", "React and UI development", 1, Arrays.asList("JavaScript", "React")),
            new JobPost(3, "Data Analyst", "Analyze and visualize data", 3, Arrays.asList("Python", "SQL", "Tableau")),
            new JobPost(4, "DevOps Engineer", "CI/CD pipelines and cloud infra", 2, Arrays.asList("AWS", "Docker", "Kubernetes")),
            new JobPost(5, "Android Developer", "Mobile app development", 1, Arrays.asList("Java", "Kotlin", "XML"))
    ));


    public List<JobPost> getAllJobs(){
            return jobs;
    }
    public void addJob(JobPost job){
        jobs.add(job);
    }
}
