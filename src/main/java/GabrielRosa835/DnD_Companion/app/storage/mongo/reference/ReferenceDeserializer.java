package app.storage.mongo.reference;

import app.storage.mongo.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

import static app.common.ResultUtils.*;
import static co.unruly.control.result.Transformers.*;
import static java.util.function.Function.*;

@Component
public class ReferenceDeserializer<T extends MongoEntity<T>> extends JsonDeserializer<T> {

	@Autowired
	private MongoService database;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public T deserialize(
			JsonParser p,
			DeserializationContext ctxt
	) throws IOException {
//		return MongoUtils.mapJsonToEntity(mapper, p.getText(), Reference.class)
//				.then(attempt(reference -> MongoUtils.<T>updateIdOfReference(database, reference)))
//				.then(onFailure(nullify()))
//				.either(identity(), nullify());
		return null;
	}
}