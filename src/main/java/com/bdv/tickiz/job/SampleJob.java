package com.bdv.tickiz.job;

import com.bdv.tickiz.service.SampleService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class SampleJob extends QuartzJobBean {

    @Autowired
    private SampleService sampleService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Start JOB: " + context.getFireTime());
        sampleService.sayHello();
    }
}
