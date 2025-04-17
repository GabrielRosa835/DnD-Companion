package app.storage.fragments;

import app.strategies.Command;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class ResetDatabaseCommand
   implements Command
{
   private MongoTemplate template;

   public static void resolveWith(MongoTemplate template) {
      new ResetDatabaseCommand(template).resolve();
   }

   @Override public void resolve() {
      MongoDatabase database = template.getDb();
      for (String collectionName : database.listCollectionNames()) {
         database.getCollection(collectionName).drop();
      }
   }
}
