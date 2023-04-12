package com.ipasoft.redisStackEvaluation.service;

import java.util.Optional;
import java.util.Set;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;

public interface IRedisService {
	public Optional<Persona> findById(String id);
	public Persona savePerson(Persona person);
    public Iterable<Persona> getAllPersons();
	public Iterable<Persona> findByAgeBetween(int min, int max);
	public Iterable<Persona> findByFirstNameAndLastName(String firstName, String lastName);
	public Iterable<Persona> searchByPersonalStatement(String textLike);
	public Iterable<Persona> findByAddress_City(String city);
	public Iterable<Persona> findBySkills(Set<String> skills);
}