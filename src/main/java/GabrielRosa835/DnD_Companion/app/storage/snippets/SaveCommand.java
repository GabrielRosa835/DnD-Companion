package app.storage.snippets;

import app.rpg.elements.models.IEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class SaveCommand
		implements Command {
	private MongoTemplate template;
	private String collectionName;
	private String json;

	public static void resolveWith(
			MongoTemplate template,
			ObjectMapper mapper,
			String collectionName,
			IEntity entity
	) throws JsonProcessingException {
		String json = mapper.writeValueAsString(entity);
		new SaveCommand(template, collectionName, json).resolve();
	}

	public static void resolveWith(MongoTemplate template, String collectionName, String json) {
		new SaveCommand(template, collectionName, json).resolve();
	}

	@Override
	public void resolve() {
		MongoCollection<Document> collection = GetCollectionOperation.processWith(template, collectionName);
		Document document = Document.parse(json);
		collection.insertOne(document);
	}
}
