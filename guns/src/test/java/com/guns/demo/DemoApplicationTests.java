package com.guns.demo;

import com.guns.demo.jpa.StudentReposiory;
import com.guns.demo.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentReposiory studentReposiory;


    @Test
    public void save(){

        Student student=new Student();
        studentReposiory.save(student);
        System.out.println(studentReposiory.findAll());


    }
}
