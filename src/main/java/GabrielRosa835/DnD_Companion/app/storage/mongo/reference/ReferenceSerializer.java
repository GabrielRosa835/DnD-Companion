package app.storage.mongo.reference;

import app.storage.mongo.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.jackson.*;

import java.io.*;

@JsonComponent
public class ReferenceSerializer<T extends MongoEntity<T>>
		extends JsonSerializer<T> {
	@Autowired
	private MongoService database;

	@Override
	public void serialize(
			T element,
			JsonGenerator gen,
			SerializerProvider serializers
	) throws IOException {
		if (element == null) {
			gen.writeNull();
			return;
		}
//		var reference = Reference.of(element);
//		reference = updateReferenceID(database, reference);
//		gen.writeObject(reference);
	}
}