package com.guns.demo.converter;

import com.guns.demo.common.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StuConverter implements Converter<String,Student> {
    @Override
    public Student convert(String s) {
        Student student=new Student();
        //格式id-name
        String[] values = s.split("-");
        student.setId(Integer.parseInt(values[0]));
        student.setName(values[1]);

        return student;
    }
}
