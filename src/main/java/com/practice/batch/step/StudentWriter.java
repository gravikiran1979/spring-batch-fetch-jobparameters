package com.practice.batch.step;

import com.practice.batch.model.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class StudentWriter implements ItemWriter {
    private static Logger log = LoggerFactory.getLogger(StudentWriter.class);

    @Override
    public void write(List students) throws Exception {
        log.info("Writing total {} students", students.size());
        for(int i=0;i<students.size();i++) {
            StudentDTO student = (StudentDTO)students.get(i);
            log.info("Writing now : "+student.toString());
        }
    }
}