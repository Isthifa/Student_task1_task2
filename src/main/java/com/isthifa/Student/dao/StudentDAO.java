package com.isthifa.Student.dao;

import com.isthifa.Student.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    Student update(Student student);
    void delete(int id);
}
