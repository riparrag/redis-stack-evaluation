package com.ipasoft.redisStackEvaluation.repository.redis.stack;
import java.util.Set;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface IPeopleRepository extends RedisDocumentRepository<Persona,String> {
	
	Iterable<Persona> findByAgeBetween(int minAge, int maxAge);
	Iterable<Persona> findByFirstNameAndLastName(String firstName, String lastName);
	
	//busca con like pero de palabra entera porque personalStatement fue anotado con @Searchable
	Iterable<Persona> searchByPersonalStatement(String text);
	
	//busca contra person.address.city
	Iterable<Persona> findByAddress_City(String city);
	
	// Search Persons that have one of multiple skills (OR condition)
	Iterable<Persona> findBySkills(Set<String> skills);
	
	//find by tag field, using JRediSearch "native" annotation 
	//@Query("@tags:{$tags}")
	//Iterable<Persona> findByTags(@Param("tags") Set<String> skills)
}