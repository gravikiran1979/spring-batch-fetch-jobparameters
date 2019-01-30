package com.practice.batch;

import com.practice.batch.config.SpringContextConfig;
import com.practice.batch.step.StudentReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainApplication {
    private static Logger log = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringContextConfig.class);
        context.refresh();

        log.info("Printing all beanNames loaded in ApplicationContext");
        for (String bean : Arrays.asList(context.getBeanDefinitionNames())) {
            log.info(bean);
        }

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("simpleJob");

        try {
            JobParametersBuilder jobBuilder = new JobParametersBuilder();
            jobBuilder.addString("studyingIn", "VI");
            jobBuilder.addString("schoolName", "St. Ann's School");
            JobParameters jobParameters = jobBuilder.toJobParameters();
            log.info("Starting Job execution");
            JobExecution execution = jobLauncher.run(job, jobParameters);
            log.info("Completion Status : " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("This is my MainApplication");

    }

}