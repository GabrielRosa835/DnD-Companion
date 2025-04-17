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

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RetrieveMultipleOperation<Entity extends IEntity>
   implements Operation<List<Entity>>
{
   private MongoTemplate template;
   private ObjectMapper mapper;
   private String collectionName;
   private Class<Entity> type;
   private List<String> names;

   public static <Entity extends IEntity> List<Entity> processWith (
         MongoTemplate template,
         ObjectMapper mapper,
         Collection<Entity> collection,
         String... names
   ) throws JsonProcessingException {
      List<String> nameList = Arrays.asList(names);
      return new RetrieveMultipleOperation<Entity>
            (template, mapper, collection.name(), collection.type(), nameList).process();
   }

   public static <Entity extends IEntity> List<Entity> processWith (
         MongoTemplate template,
         ObjectMapper mapper,
         String collectionName,
         Class<Entity> type,
         String... names
   ) throws JsonProcessingException {
      List<String> nameList = Arrays.asList(names);
      return new RetrieveMultipleOperation<Entity>
            (template, mapper, collectionName, type, nameList).process();
   }

   @Override public List<Entity> process () throws JsonProcessingException {
      MongoCollection<Document> collection = GetCollectionOperation.processWith(template, collectionName);
      List<Document> queries = names.stream()
            .map(name -> new Document("name",
                  new Document("$regex", "^" + name + "$").append("$options", "i")))
            .collect(Collectors.toList());
      List<Document> results = collection
            .find(new Document("$or", queries))
            .into(new ArrayList<>());
      List<Entity> entities = new ArrayList<>();
      for (Document result : results) {
         String json = "";
         if (result != null) json = result.toJson();
         entities.add(mapper.readValue(json, type));
      }
      return entities;
   }
}
