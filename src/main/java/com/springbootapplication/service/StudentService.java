package com.springbootapplication.service;

import com.springbootapplication.model.Student;
import com.springbootapplication.repositary.StudentRepositary;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepositary studentRepositary;

    // below methods for CRUD operation -> CREATE , READ , UPDATE , DELETE

    //create
    public Student addStudent(Student student){
        //generate id
        student.setStudentId(UUID.randomUUID().toString().split("-")[0]);
        return studentRepositary.save(student);
    }

    //Read is return the list of students in db
    public List<Student> readAllStudents(){
        return studentRepositary.findAll();
    }

    //get student by id
    public Student getStudentById(String studentId){
        return studentRepositary.findById(studentId).get();
    }

    // update student
    public Student updateStudent(Student student){
      Student existingStudent =  studentRepositary.findById(student.getStudentId()).get();
      existingStudent.setStudentName(student.getStudentName());
      existingStudent.setDepartment(student.getDepartment());
      existingStudent.setSection(student.getSection());
      existingStudent.setFinalYearrProject(student.getFinalYearrProject());

      return studentRepositary.save(existingStudent);


    }
    //delete student

    public String deleteStudent(String studentId){
         studentRepositary.deleteById(studentId);
         return studentId + "  studentid deleted from Database";

    }


}
