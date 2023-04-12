package com.ipasoft.redisStackEvaluation.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;
import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.ZipCode;
import com.ipasoft.redisStackEvaluation.repository.redis.stack.IZipCodeRepository;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeController {
	private final IZipCodeRepository zipCodeRepository;
	
	public ZipCodeController(IZipCodeRepository zipCodeRepository) {
		this.zipCodeRepository = zipCodeRepository;
	}
	
	@GetMapping("/{id}")
	public Optional<ZipCode> findById(@PathVariable String id) {
		return this.zipCodeRepository.findById(id);
	}
	
	@GetMapping("/find-by-city/{city}")
	public Iterable<ZipCode> byCity(@PathVariable("city") String city) {
	  return this.zipCodeRepository.findByCity(city);
	}
}