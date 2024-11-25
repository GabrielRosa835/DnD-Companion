package dnd_companion.local_storage.data.manipulation;

import java.util.Arrays;

import dnd_companion.local_storage.data.structure.options.ItemTag;
import dnd_companion.local_storage.data_validation.DataValidator;

public record ItemTags(ItemTag[] tags) 
{	
	public ItemTags(String... tag_names) {
		this(
			(ItemTag[]) DataValidator.validate_options(
				Arrays.stream(tag_names)
				.map(tag -> new ItemTag(tag))
				.toArray(ItemTag[]::new)
			)
		);
	}
}
