package dnd_companion.entities.armor_related.armor_category;

import javax.xml.crypto.Data;

import dnd_companion.common.metadata.CollectionREF;

public record ArmorCategoryData (
	String name,
	double don_time_value,
	String don_time_unit,
	double doff_time_value,
	String doff_time_unit
) implements Data {
	@Override public CollectionREF collection() {return collections.armor_categories();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
