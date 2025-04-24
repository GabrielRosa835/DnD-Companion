package app.storage.snippets;

import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class EmptyCollectionCommand
		implements Command {
	private MongoTemplate template;
	private String name;

	public static void resolveWith(MongoTemplate template, String name) {
		new EmptyCollectionCommand(template, name).resolve();
	}

	@Override
	public void resolve() {
		MongoCollection<Document> collection = GetCollectionOperation.processWith(template, name);
		collection.deleteMany(new Document());
	}
}
