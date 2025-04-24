package app.storage.snippets;

import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class EmptyDatabaseCommand
		implements Command {
	private MongoTemplate template;

	public static void resolveWith(MongoTemplate template) {
		new EmptyDatabaseCommand(template).resolve();
	}

	@Override
	public void resolve() {
		MongoDatabase database = template.getDb();
		for (String collectionName : database.listCollectionNames()) {
			EmptyCollectionCommand.resolveWith(template, collectionName);
		}
	}
}
