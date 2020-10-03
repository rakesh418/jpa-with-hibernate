package com.lex418.jpa.hibernate.demo.repository;
import com.lex418.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager em;

    @Test
    void findById() {
        Course course = courseRepository.findById(10001);
        assertEquals("JPA in 50 Steps",course.getName());
    }

    @Test
    @DirtiesContext
    void deleteById() {
        courseRepository.deleteById(10001);
        assertNull(courseRepository.findById(10001));
    }

    @Test
    @DirtiesContext
    void save() {
        Course course = courseRepository.findById(10003);
        assertEquals("Kafka in 50 Steps",course.getName());
        course.setName("Kafka in 50 Steps -updated");
        courseRepository.save(course);

        Course course1 = courseRepository.findById(10003);
        assertEquals("Kafka in 50 Steps -updated",course1.getName());
    }

    @Test
    @DirtiesContext
    void playWithEntityManager() {
//        courseRepository.playWithEntityManager();
//        List<Course> courses= em.createQuery("select c from Course c").getResultList();ypes
        TypedQuery<Course> courseTypedQuery = em.createQuery("select c from Course c", Course.class);
        List<Course> courses = courseTypedQuery.getResultList();
        logger.info(courses.toString());

//        Query query = em.createNativeQuery("select * from course where id = ? ", Course.class);
        Query query = em.createNativeQuery("select * from course where id = :id ", Course.class);
//        query.setParameter(1,10001);
        query.setParameter("id",10001);
        List<Course> courseList = query.getResultList();
        logger.info(courseList.toString());
    }
}