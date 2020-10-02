package com.lex418.jpa.hibernate.demo.repository;
import com.lex418.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

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
}