package com.lex418.spring.basic.jpahibernate.jpa;

import com.lex418.spring.basic.jpahibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @Autowired
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person",Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
