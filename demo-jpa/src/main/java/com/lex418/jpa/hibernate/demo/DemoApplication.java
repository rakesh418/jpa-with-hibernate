package com.lex418.jpa.hibernate.demo;

import com.lex418.jpa.hibernate.demo.entity.Course;
import com.lex418.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = courseRepository.findById(10001L);
        logger.info("Course name --> {}", course);

        courseRepository.save(new Course("Microservices Beta"));
//        courseRepository.deleteById(10001);
//        courseRepository.playWithEntityManager();
    }
}
