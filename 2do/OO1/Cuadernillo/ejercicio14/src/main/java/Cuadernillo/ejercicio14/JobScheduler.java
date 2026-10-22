package Cuadernillo.ejercicio14;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected String policy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
        this.policy = "FIFO";
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public String getPolicy() {
        return this.policy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public JobDescription next() {
        JobDescription nextJob = null;

        switch (policy) {
            case "FIFO":
                nextJob = jobs.get(0);
                this.unschedule(nextJob);
                return nextJob;

            case "LIFO":
                nextJob = jobs.get(jobs.size()-1);
                this.unschedule(nextJob);
                return nextJob;

            case "HighestPriority":
                nextJob = jobs.stream()
                    .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                    .orElse(null);
                this.unschedule(nextJob);
                return nextJob;

            case "MostEffort":
                nextJob = jobs.stream()
                    .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                    .orElse(null);
                this.unschedule(nextJob);
                return nextJob;
        }
        return null;
    }

}
