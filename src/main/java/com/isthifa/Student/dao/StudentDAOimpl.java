package com.isthifa.Student.dao;

import com.isthifa.Student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOimpl(EntityManager entityManage)
    {
        entityManager=entityManage;
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> temp=entityManager.createQuery("from Student",Student.class);
        return temp.getResultList();
    }

    @Override
    public Student findById(int id) {
        Student temp=entityManager.find(Student.class,id);
        return temp;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student update(Student student) {
        entityManager.merge(student);
        return student;
    }


    @Override
    @Transactional
    public void delete(int id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
}
