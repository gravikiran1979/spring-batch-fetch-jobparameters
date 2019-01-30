package com.practice.batch.config;

import com.practice.batch.step.StudentReader;
import com.practice.batch.step.StudentWriter;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.*;

import java.util.Map;

@Configuration
@ComponentScan("com.practice.batch")
@ImportResource("classpath:batch-jobs/applicationContext.xml")
public class SpringContextConfig {

//    @Bean
//    @StepScope
//    public StudentReader studentReader(@Value("#{jobParameters['studyingIn'}") String studyingIn,
//            @Value("#{jobParameters['schoolName'}") String schoolName) {
//        StudentReader studentReader = new StudentReader();
//        studentReader.setStudyingIn(studyingIn);
//        studentReader.setSchoolName(schoolName);
//        return studentReader;
//    }

    @Bean
    public StudentWriter studentWriter() {
        return new StudentWriter();
    }
}
