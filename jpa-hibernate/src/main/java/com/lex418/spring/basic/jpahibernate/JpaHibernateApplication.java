package com.lex418.spring.basic.jpahibernate;

import com.lex418.spring.basic.jpahibernate.entity.Person;
import com.lex418.spring.basic.jpahibernate.jdbc.PersonJdbcDao;
import com.lex418.spring.basic.jpahibernate.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users --> {} ", personJpaRepository.findAll());
//
        logger.info("User id 10001 find -> {}",personJpaRepository.findById(10001));
//
        personJpaRepository.deleteById(10001);
//
        logger.info("User id 10004 insert -> {}",personJpaRepository.insert(new Person("Papu","Sivasagar", new Date())));
//
        logger.info("User id 10003 update-> {}",personJpaRepository.update(new Person(10004,"Pieter","Paris", new Date())));
//
//        logger.info("All users --> {} ", personJdbcDao.findAll());
    }
}
