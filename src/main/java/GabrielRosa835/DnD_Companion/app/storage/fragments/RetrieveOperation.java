package app.storage.fragments;

import app.strategies.Operation;
import app.rpg.models.IEntity;
import app.storage.Collection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
public class RetrieveOperation<Entity extends IEntity>
   implements Operation<Entity>
{
   private MongoTemplate template;
   private ObjectMapper mapper;
   private String collectionName;
   private String name;
   private Class<Entity> type;

   public static <Entity extends IEntity> Entity processWith (
         MongoTemplate template,
         ObjectMapper mapper,
         Collection<Entity> collection,
         String name
   ) throws JsonProcessingException {
      return new RetrieveOperation<Entity>(template, mapper, collection.name(), name, collection.type()).process();
   }

   public static <Entity extends IEntity> Entity processWith (
         MongoTemplate template,
         ObjectMapper mapper,
         String collectionName,
         String name,
         Class<Entity> type
   ) throws JsonProcessingException {
      return new RetrieveOperation<Entity>(template, mapper, collectionName, name, type).process();
   }

   @Override public Entity process () throws JsonProcessingException {
      MongoCollection<Document> collection = GetCollectionOperation.processWith(template, collectionName);
      Document query = new Document("name", new Document("$regex", "^"+name+"$").append("$options", "i"));
      Document result = collection.find(query).first();
      if (result != null)
         return mapper.readValue(result.toJson(), type);
      else {
         return null;
      }
   }
}
