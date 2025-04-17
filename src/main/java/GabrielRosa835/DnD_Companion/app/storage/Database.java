package app.storage;

import app.rpg.models.IEntity;
import app.storage.fragments.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Database
{
   private Database () {}
   private static Database instance;
   public static Database get() {
      return instance == null? new Database() : instance;
   }

   @Autowired
   private MongoTemplate template;
   private final ObjectMapper mapper = new ObjectMapper();

   public void save (String collectionName, String json) {
      SaveCommand.resolveWith(template, collectionName, json);
   }
   public void save (String collectionName, IEntity entity) throws JsonProcessingException {
      SaveCommand.resolveWith(template, mapper, collectionName, entity);
   }

   public void saveMultiple(String collectionName, String... jsons) {
      SaveMultipleCommand.resolveWith(template, collectionName, jsons);
   }
   public void saveMultiple(String collectionName, IEntity... entities) throws JsonProcessingException {
      SaveMultipleCommand.resolveWith(template, mapper, collectionName, entities);
   }

   public <Entity extends IEntity> Entity retrieve(String collectionName, String name, Class<Entity> type)
   throws JsonProcessingException {
      return RetrieveOperation.processWith(template, mapper, collectionName, name, type);
   }
   public <Entity extends IEntity> Entity retrieve(Collection<Entity> collection, String name)
   throws JsonProcessingException {
      return RetrieveOperation.processWith(template, mapper, collection, name);
   }

   public <Entity extends IEntity> List<Entity> retrieveMultiple(
         String collectionName, Class<Entity> type, String... names
   ) throws JsonProcessingException {
      return RetrieveMultipleOperation.processWith(template, mapper, collectionName, type, names);
   }
   public <Entity extends IEntity> List<Entity> retrieveMultiple(
         Collection<Entity> collection, String... names
   ) throws JsonProcessingException {
      return RetrieveMultipleOperation.processWith(template, mapper, collection, names);
   }

   public void createCollections(String... names) {
      CreateCollectionsCommand.resolveWith(template, names);
   }
   public void deleteCollections(String... names) {
      DeleteCollectionsCommand.resolveWith(template, names);
   }

   public void clearCollection (String name) {
      EmptyCollectionCommand.resolveWith(template, name);
   }
   public void clearDatabase () {
      EmptyDatabaseCommand.resolveWith(template);
   }
   public void resetDatabase () {
      ResetDatabaseCommand.resolveWith(template);
   }
}
