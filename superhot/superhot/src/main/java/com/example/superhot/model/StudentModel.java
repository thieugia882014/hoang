package com.example.superhot.model;


import com.example.superhot.entity.Student;

import java.util.List;

public interface StudentModel {
    Student save(Student student); // lưu thông tin.

    List<Student> findAll();

    Student findById(String rollNumber);

    Student update(String rollNumber, Student updateStudent);

    boolean delete(String rollNumber);
}
