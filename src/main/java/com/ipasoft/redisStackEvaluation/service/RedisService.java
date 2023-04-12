package com.ipasoft.redisStackEvaluation.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;
import com.ipasoft.redisStackEvaluation.repository.redis.stack.IPeopleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisService implements IRedisService {
	//private final RedisTemplate<String, String> redisTemplate;
	private final IPeopleRepository peopleRepository;

	public RedisService(IPeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	/*
	private final EntityStream entityStream;
	public RedisService(IPeopleRepository peopleRepository, EntityStream entityStream) {
		this.peopleRepository = peopleRepository;
		this.entityStream = entityStream;
	}
	// Find all people
	public Iterable<Person> findAllPeople(int minAge, int maxAge) {
		return entityStream.of(Person.class)
						   .collect(Collectors.toList());
	}*/

	@Override
	public Optional<Persona> findById(String id) {
		return this.peopleRepository.findById(id);
	}

	@Override
	public Persona savePerson(Persona person) {
		return this.peopleRepository.save(person);
	}

	@Override
	public Iterable<Persona> getAllPersons() {
		return this.peopleRepository.findAll();
	}

	@Override
	public Iterable<Persona> findByAgeBetween(int min, int max) {
		return this.peopleRepository.findByAgeBetween(min, max);
	}

	@Override
	public Iterable<Persona> findByFirstNameAndLastName(String firstName, String lastName) {
		return this.peopleRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public Iterable<Persona> searchByPersonalStatement(String textLike) {
		return this.peopleRepository.searchByPersonalStatement(textLike);
	}

	@Override
	public Iterable<Persona> findByAddress_City(String city) {
		return this.peopleRepository.findByAddress_City(city);
	}

	@Override
	public Iterable<Persona> findBySkills(Set<String> skills) {
		return this.peopleRepository.findBySkills(skills);
	}
}