package com.practice.batch.step;

import com.practice.batch.model.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<StudentDTO, StudentDTO> {

    private static Logger log = LoggerFactory.getLogger(StudentReader.class);

    private String studyingIn;
    private String schoolName;

    public StudentProcessor(String studyingIn, String schoolName) {
        this.studyingIn = studyingIn;
        this.schoolName = schoolName;
    }

    @Override
    public StudentDTO process(StudentDTO student) throws Exception {
        log.info("StudentProcessor :: Current Student: "+ student.getName());
        student.setStudingIn(studyingIn);
        student.setSchoolName(schoolName);
        return student;
    }
}
