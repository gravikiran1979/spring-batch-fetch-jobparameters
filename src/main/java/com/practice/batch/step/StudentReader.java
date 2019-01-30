package com.practice.batch.step;

import com.practice.batch.model.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StudentReader implements ItemReader<StudentDTO> {

    private static Logger log = LoggerFactory.getLogger(StudentReader.class);
    private String studyingIn;

    private int nextStudentIndex;
    private List<StudentDTO> studentData;

    public StudentReader() {
        initialize();
    }

    private void initialize() {
        log.info("StudentReader :: Initializing StudentData");

        StudentDTO tony = new StudentDTO();
        tony.setEmailAddress("tony.tester@gmail.com");
        tony.setName("Tony Tester");
        tony.setPurchasedPackage("master");

        StudentDTO nick = new StudentDTO();
        nick.setEmailAddress("nick.newbie@gmail.com");
        nick.setName("Nick Newbie");
        nick.setPurchasedPackage("starter");

        StudentDTO ian = new StudentDTO();
        ian.setEmailAddress("ian.intermediate@gmail.com");
        ian.setName("Ian Intermediate");
        ian.setPurchasedPackage("intermediate");

        studentData = Collections.unmodifiableList(Arrays.asList(tony, nick, ian));
        nextStudentIndex = 0;
    }

    @Override
    public StudentDTO read() throws Exception {
        log.info("StudentReader :: Reading student data");
        StudentDTO nextStudent = null;
        if (nextStudentIndex < studentData.size()) {
            nextStudent = studentData.get(nextStudentIndex);
            nextStudentIndex++;
        }
        return nextStudent;
    }
}