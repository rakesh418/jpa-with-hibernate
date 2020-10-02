package com.lex418.jpa.hibernate.demo.repository;


import com.lex418.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(int id){
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        entityManager.merge(course);
        return course;
    }
}
