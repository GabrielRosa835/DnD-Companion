package app.storage.snippets;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class DeleteCollectionsCommand
		implements Command {
	private MongoTemplate template;
	private List<String> names;

	public static void resolveWith(MongoTemplate template, String... names) {
		List<String> nameList = Arrays.asList(names);
		new DeleteCollectionsCommand(template, nameList).resolve();
	}

	@Override
	public void resolve() {
		MongoDatabase database = template.getDb();
		for (String name : names) {
			MongoCollection<Document> collection =
					GetCollectionOperation.processWith(template, name);
			collection.drop();
		}
	}
}
