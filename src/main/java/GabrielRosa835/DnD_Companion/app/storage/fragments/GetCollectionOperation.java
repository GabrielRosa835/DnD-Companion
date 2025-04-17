package app.storage.fragments;

import app.strategies.Operation;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class GetCollectionOperation
   implements Operation<MongoCollection<Document>>
{
   private MongoTemplate template;
   private String collectionName;

   public static MongoCollection<Document> processWith (MongoTemplate template, String collectionName) {
      return new GetCollectionOperation(template, collectionName).process();
   }

   @Override public MongoCollection<Document> process () {
      MongoDatabase database = template.getDb();
      return database.getCollection(collectionName);
   }
}
