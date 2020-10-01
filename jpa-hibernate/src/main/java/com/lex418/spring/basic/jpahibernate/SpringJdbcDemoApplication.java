package com.lex418.spring.basic.jpahibernate;

import com.lex418.spring.basic.jpahibernate.entity.Person;
import com.lex418.spring.basic.jpahibernate.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users --> {} ", personJdbcDao.findAll());

        logger.info("User id 10001 find -> {}",personJdbcDao.findById(10001));

        logger.info("User id 10001 delete -> {}",personJdbcDao.deleteById(10001));

        logger.info("User id 10004 insert -> {}",personJdbcDao.insert(new Person(10005,"Papu","Sivasagar", new Date())));

        logger.info("User id 10003 update-> {}",personJdbcDao.update(new Person(10003,"Pieter","Paris", new Date())));

        logger.info("All users --> {} ", personJdbcDao.findAll());
    }
}
