package dnd_companion.local_storage.data_deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.local_storage.data_structure.java.items.armors.Armor;
import dnd_companion.local_storage.data_structure.java.system.units.Price;
import dnd_companion.local_storage.data_structure.java.system.units.Weight;

public class ArmorDeserializer extends JsonDeserializer<Armor>
{
	@Override
	public Armor deserialize(
		JsonParser p,
		@SuppressWarnings("unused") DeserializationContext ctxt
	) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);

		String name = node.get("name").asText();
		double price_value = node.get("price_value").asDouble();
		String price_unit = node.get("price_unit").asText();
		double weight_value = node.get("weight_value").asDouble();
		String weight_unit = node.get("weight_unit").asText();

		ObjectMapper mapper = (ObjectMapper) p.getCodec();
        String[] tags = mapper.readValue(node.get("tags").traverse(), String[].class);

        String description = node.get("description").asText();
        String category = node.get("category").asText();
        int armor_class = node.get("armor_class").asInt();
        int strength_requirement = node.get("strength_requirement").asInt();
        boolean stealth_disadvantage = node.get("stealth_disadvantage").asBoolean();

        return new Armor(
    		name,
    		new Price(price_value, price_unit),
    		new Weight(weight_value, weight_unit),
    		tags,
    		description,
    		category,
    		armor_class,
    		strength_requirement,
    		stealth_disadvantage
		);
	}
}
