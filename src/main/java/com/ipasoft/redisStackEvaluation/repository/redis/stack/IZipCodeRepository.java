package com.ipasoft.redisStackEvaluation.repository.redis.stack;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.ZipCode;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface IZipCodeRepository extends RedisDocumentRepository<ZipCode,String> {

	Iterable<ZipCode> findByCity(String city);

}