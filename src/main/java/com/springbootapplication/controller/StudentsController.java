package com.springbootapplication.controller;


import com.springbootapplication.model.Student;
import com.springbootapplication.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentsController{

    Logger logger = LoggerFactory.getLogger(StudentsController.class);

    @Autowired
    StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        logger.info("adding student");
        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        logger.info("getting all student");
        return service.readAllStudents();
    }
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        logger.info("get "+studentId + " student");
        return service.getStudentById(studentId);
    }

    @PutMapping
    public Student modifyStudent(@RequestBody Student student){
        logger.info("updating student");
        return service.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable String studentId){
        logger.info("deleted "+studentId + " student");
      return service.deleteStudent(studentId);
    }
}
