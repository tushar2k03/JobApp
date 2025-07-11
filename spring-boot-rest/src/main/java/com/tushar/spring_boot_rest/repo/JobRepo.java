package com.tushar.spring_boot_rest.repo;

import com.tushar.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}

//    public List<JobPost> getAllJobs(){
//            return jobs;
//    }
//    public void addJob(JobPost job){
//        jobs.add(job);
//    }
//
//    public JobPost getJob(int postId) {
//        for(JobPost job : jobs) {
//            if(job.getPostId() == postId) {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost job) {
//        for(JobPost job1 : jobs) {
//            if(job.getPostId() == job1.getPostId()) {
//                job1.setPostDesc(job.getPostDesc());
//                job1.setPostId(job.getPostId());
//                job1.setPostProfile(job.getPostProfile());
//                job1.setReqExperience(job.getReqExperience());
//                job1.setPostTechStack(job1.getPostTechStack());
//                //Use Break because we don't wanna to iterate till end once we update our job than out task is done
//                break;
//            } else {
//                /* *
//                 * code when jobId not found,
//                 * or we can put this if inside try catch
//                 */
//                System.out.println("Gad-bad Hai re Kuch");
//            }
//        }
//    }
//
//    public String deleteJob(int postId) {
//            for(JobPost job : jobs) {
//                if(job.getPostId() == postId) {
//                    jobs.remove(job);
//                    return "Done Sher Kr diya Delete";
//                }
//            }
//            return "Yrr Job Nhi mile";
//    }
//}
