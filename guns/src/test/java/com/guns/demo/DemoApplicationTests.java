package com.guns.demo;

import com.guns.demo.jpa.ClassRepository;
import com.guns.demo.jpa.StudentRepository;
import com.guns.demo.model.Class;
import com.guns.demo.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;


    @Test
    public void save(){

        Student student=new Student();
        student.setId(0L);
        student.setName("123");

        studentRepository.save(student);
        System.out.println(studentRepository.findAll());


    }

    @Test
    public void getStuByClassId(){
        List<Student> studentList = studentRepository.findAllByClassId(1L);
        System.out.println(studentList);


    }

    @Test
    public void savacl(){
        Class c=new Class();
        classRepository.save(c);

    }
    @Test
    public void classs(){

        System.out.println(classRepository.findAll());;

    }
}
