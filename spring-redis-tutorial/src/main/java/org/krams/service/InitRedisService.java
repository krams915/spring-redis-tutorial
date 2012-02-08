package org.krams.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Service for initializing Redis with sample data
 */
public class InitRedisService {

	@Autowired
	private RedisTemplate<String, String> template;
	
	public void init() {
		// Delete existing ones

		String key = "user"+"john";
		template.opsForHash().delete(key, "id");
		template.opsForHash().delete(key, "firstName");
		template.opsForHash().delete(key, "lastName");
		template.opsForHash().delete(key, "username");
		template.opsForHash().delete(key, "password");
		template.opsForHash().delete(key, "role");
		
		key = "user"+"jane";
		template.opsForHash().delete(key, "id");
		template.opsForHash().delete(key, "firstName");
		template.opsForHash().delete(key, "lastName");
		template.opsForHash().delete(key, "username");
		template.opsForHash().delete(key, "password");
		template.opsForHash().delete(key, "role");
		
		// Create new records
		key = "user"+"john";
		template.opsForHash().put(key, "id", UUID.randomUUID().toString());
		template.opsForHash().put(key, "firstName", "John");
		template.opsForHash().put(key, "lastName", "Smith");
		template.opsForHash().put(key, "username", "john");
		template.opsForHash().put(key, "password", "21232f297a57a5a743894a0e4a801fc3");
		template.opsForHash().put(key, "role", "1");
		template.opsForSet().add("user", key);
		
		key = "user"+"jane";
		template.opsForHash().put(key, "id", UUID.randomUUID().toString());
		template.opsForHash().put(key, "firstName", "Jane");
		template.opsForHash().put(key, "lastName", "Adams");
		template.opsForHash().put(key, "username", "jane");
		template.opsForHash().put(key, "password", "ee11cbb19052e40b07aac0ca060c23ee");
		template.opsForHash().put(key, "role", "2");
		template.opsForSet().add("user", key);
	}
}
