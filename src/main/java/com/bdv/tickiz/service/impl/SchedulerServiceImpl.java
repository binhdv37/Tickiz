package com.bdv.tickiz.service.impl;

import com.bdv.tickiz.job.SampleJob;
import com.bdv.tickiz.service.SchedulerService;
import jakarta.annotation.PostConstruct;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void scheduleJob() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)
                .withIdentity("myJob", "myGroup")
                .storeDurably()
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "myGroup")
                .startAt(new Date(System.currentTimeMillis() + 5000))  // Start after 5 seconds
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)  // Repeat every 10 seconds
                        .repeatForever())
                .build();

        if (!scheduler.checkExists(jobDetail.getKey())) {
            scheduler.scheduleJob(jobDetail, trigger);
        }
    }

}
