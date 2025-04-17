package app.storage.fragments;

import app.strategies.Command;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class CreateCollectionsCommand
   implements Command
{
   private MongoTemplate template;
   private List<String> names;

   public static void resolveWith (MongoTemplate template, String... names) {
      List<String> nameList = Arrays.asList(names);
      new CreateCollectionsCommand(template, nameList).resolve();
   }

   @Override public void resolve () {
      MongoDatabase database = template.getDb();
      for (String name : names) {
         database.createCollection(name);
      }
   }
}
