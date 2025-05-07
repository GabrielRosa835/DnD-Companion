package app.storage.mongo;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.*;
import com.mongodb.client.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;

@Configuration
public class MongoConfig {

	public final String DB_NAME = "dnd-companion";

	@Bean
	public MongoTemplate template() {
		return new MongoTemplate(MongoClients.create("mongodb://localhost:27017/" + DB_NAME), DB_NAME);
	}

	@Bean
	public ObjectMapper mapper() {
		var mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		var module = new SimpleModule();
		mapper.registerModule(module);
		return mapper;
	}
}