package com.springbootapplication.repositary;

import com.springbootapplication.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepositary  extends MongoRepository<Student,String> {



}
