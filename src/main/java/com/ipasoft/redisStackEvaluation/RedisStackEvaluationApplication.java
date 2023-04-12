package com.ipasoft.redisStackEvaluation;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;

import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Address;
import com.ipasoft.redisStackEvaluation.mode.entity.redis.stack.Persona;
import com.ipasoft.redisStackEvaluation.repository.redis.stack.IPeopleRepository;
import com.ipasoft.redisStackEvaluation.repository.redis.stack.IZipCodeRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;

// @EnableRedisDocumentRepositories(basePackages = "com.ipasoft.redisStackEvaluation.repository.redis.stack")
@EnableRedisDocumentRepositories
@SpringBootApplication
public class RedisStackEvaluationApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisStackEvaluationApplication.class, args);
	}

	@Bean
	CommandLineRunner loadTestData(IPeopleRepository peopleRepository, IZipCodeRepository zipCodeRepository) {
		return args -> {
			//peopleRepository.deleteAll();

			String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You.";
	
			// Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
			Address thorsAddress = Address.of("248", "Seven Mile Beach Rd", "Broken Head", "NSW", "2481", "Australia");
	
			Persona thor = Persona.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress, Set.of("hammer", "biceps", "hair", "heart"));
	
			peopleRepository.save(thor);

			thorSays = "Again The Rabbit Is Correct, And Clearly The Smartest One Among You.";
		    String ironmanSays = "Doth mother know you weareth her drapes?";
		    String blackWidowSays = "Hey, fellas. Either one of you know where the Smithsonian is? I’m here to pick up a fossil.";
		    String wandaMaximoffSays = "You Guys Know I Can Move Things With My Mind, Right?";
		    String gamoraSays = "I Am Going To Die Surrounded By The Biggest Idiots In The Galaxy.";
		    String nickFurySays = "Sir, I’m Gonna Have To Ask You To Exit The Donut";

		    Address ironmansAddress = Address.of("11", "Commerce Dr", "Riverhead", "NY",  "11901", "US");
		    Address blackWidowAddress = Address.of("605", "48th St", "New York", "NY", "10019", "US");
		    Address wandaMaximoffsAddress = Address.of("20", "W 34th St", "New York", "NY", "10001", "US");
		    Address gamorasAddress = Address.of("107", "S Beverly Glen Blvd", "Los Angeles", "CA", "90024", "US");
		    Address nickFuryAddress = Address.of("11461", "Sunset Blvd", "Los Angeles", "CA", "90049", "US");

		    thor = Persona.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress, Set.of("hammer", "biceps", "hair", "heart"));
		    Persona ironman = Persona.of("Robert", "Downey", 56, ironmanSays, new Point(40.9190747, -72.5371874), ironmansAddress, Set.of("tech", "money", "one-liners", "intelligence", "resources"));
		    Persona blackWidow = Persona.of("Scarlett", "Johansson", 37, blackWidowSays, new Point(40.7215259, -74.0129994), blackWidowAddress, Set.of("deception", "martial_arts"));
		    Persona wandaMaximoff = Persona.of("Elizabeth", "Olsen", 32, wandaMaximoffSays, new Point(40.6976701, -74.2598641), wandaMaximoffsAddress, Set.of("magic", "loyalty"));
		    Persona gamora = Persona.of("Zoe", "Saldana", 43, gamoraSays, new Point(-118.399968, 34.073087), gamorasAddress, Set.of("skills", "martial_arts"));
		    Persona nickFury = Persona.of("Samuel L.", "Jackson", 73, nickFurySays, new Point(-118.4345534, 34.082615), nickFuryAddress, Set.of("planning", "deception", "resources"));

		    peopleRepository.saveAll(List.of(thor, ironman, blackWidow, wandaMaximoff, gamora, nickFury));
		    
		    //zipCodeRepository.bulkLoad("src/main/resources/static/data/zips.json");
	   };
	}	
}