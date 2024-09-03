package com.mateusflores.rest_with_spring_boot.services;

import com.mateusflores.rest_with_spring_boot.data.vo.PersonVO;
import com.mateusflores.rest_with_spring_boot.exceptions.ResourceNotFoundException;
import com.mateusflores.rest_with_spring_boot.mapper.DozerMapper;
import com.mateusflores.rest_with_spring_boot.model.Person;
import com.mateusflores.rest_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public PersonVO findById(Long id) {
        return DozerMapper.parseObject(personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
                PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating a person!");

        return DozerMapper.parseObject(
                personRepository.save(DozerMapper.parseObject(person, Person.class)),
                PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating a person!");

        Person entity = DozerMapper.parseObject(this.findById(person.getId()), Person.class);
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        personRepository.delete(DozerMapper.parseObject(this.findById(id), Person.class));
    }
}
