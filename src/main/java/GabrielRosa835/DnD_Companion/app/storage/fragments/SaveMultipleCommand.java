package app.storage.fragments;

import app.strategies.Command;
import app.rpg.models.IEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SaveMultipleCommand
   implements Command
{
   private MongoTemplate template;
   private String collectionName;
   private List<String> jsons;

   public static void resolveWith (
         MongoTemplate template,
         ObjectMapper mapper,
         String collectionName,
         IEntity... entities
   ) throws JsonProcessingException {
      List<String> jsons = new ArrayList<>();
      for (IEntity entity : entities) {
         jsons.add(mapper.writeValueAsString(entity));
      }
      new SaveMultipleCommand(template, collectionName, jsons).resolve();
   }
   public static void resolveWith (
         MongoTemplate template,
         String collectionName,
         String... jsons
   ) {
      List<String> jsonList = Arrays.asList(jsons);
      new SaveMultipleCommand(template, collectionName, jsonList).resolve();
   }

   @Override public void resolve () {
      MongoCollection<Document> collection = GetCollectionOperation.processWith(template, collectionName);
      List<Document> documents = jsons.stream()
            .map(Document::parse)
            .collect(Collectors.toList());
      collection.insertMany(documents);
   }
}
