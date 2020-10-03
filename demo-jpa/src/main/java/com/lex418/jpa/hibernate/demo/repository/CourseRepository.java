package com.lex418.jpa.hibernate.demo.repository;


import com.lex418.jpa.hibernate.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        entityManager.merge(course);
        return course;
    }

    public void playWithEntityManager(){
        Course course = new Course("Play with Microservices");
        entityManager.persist(course);
        course.setName("Play with Microservices -- Updated");
        entityManager.flush();
        entityManager.clear();
        entityManager.refresh(course);
        entityManager.detach(course);
    }
}
