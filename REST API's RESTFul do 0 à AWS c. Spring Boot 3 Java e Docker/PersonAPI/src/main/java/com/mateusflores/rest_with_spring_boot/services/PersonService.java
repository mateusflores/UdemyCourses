package com.mateusflores.rest_with_spring_boot.services;

import com.mateusflores.rest_with_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("Finding one person!");

        return mockPerson(String.valueOf(counter.incrementAndGet()));
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        logger.info("Finding all people!");

        for (int i=0; i<8; i++) {
            Person person = mockPerson(String.valueOf(i));
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(String id) {
        Person person = new Person();

        person.setId(Long.valueOf(id));
        person.setFirstName("Person first name " + id);
        person.setLastName("Person last name " + id);
        person.setGender("Person gender " + id);
        person.setAddress("City " + id);

        return person;
    }
}
