package com.ipasoft.redisStackEvaluation.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;
import com.ipasoft.redisStackEvaluation.service.IRedisService;

@RestController
@RequestMapping("/redis")
public class RedisPersonController {
	private final IRedisService redisService;
	
	public RedisPersonController(IRedisService redisService) {
		this.redisService = redisService;
	}
	
	@GetMapping("/person/{id}")
	public Optional<Persona> findById(@PathVariable String id) {
		return this.redisService.findById(id);
	}
	
	@GetMapping("/person/age_between")
	public Iterable<Persona> byAgeBetween(@RequestParam("min") int min, @RequestParam("max") int max) {
	  return this.redisService.findByAgeBetween(min, max);
	}

	@GetMapping("/person/name")
	public Iterable<Persona> byFirstNameAndLastName(@RequestParam("first") String firstName, @RequestParam("last") String lastName) {
	  return this.redisService.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public @GetMapping("/person/personstatement")
	Iterable<Persona> byPersonalStatement(@RequestParam("textLike") String textLike) {
	  return this.redisService.searchByPersonalStatement(textLike);
	}
	
	@GetMapping("/person/city")
	public Iterable<Persona> byCity(@RequestParam("city") String city) {
	  return this.redisService.findByAddress_City(city);
	}
	
	@GetMapping("skills")
	public Iterable<Persona> byAnySkills(@RequestParam("skills") Set<String> skills) {
	  return this.redisService.findBySkills(skills);
	}

	@GetMapping("/person/get-all")
	public Iterable<Persona> getAll() {
		return this.redisService.getAllPersons();
	}
	
	@PostMapping("/person")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persona savePerson(@RequestBody Persona person) {
		return this.redisService.savePerson( person );
	}
}