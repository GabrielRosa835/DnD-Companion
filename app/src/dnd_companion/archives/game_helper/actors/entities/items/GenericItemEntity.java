package dnd_companion.archives.game_helper.actors.entities.items;

import java.util.Arrays;

import dnd_companion.archives.game_helper.actors.models.ItemComponent;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.components.Price;
import dnd_companion.entities.addons.components.Weight;
import dnd_companion.entities.item_related.GenericItemData;
import dnd_companion.storage.archives.handling.DataHandler;

public class GenericItemEntity implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private Price price;
	@Override public Price price() {return this.price;}
	
	private Weight weight;
	@Override public Weight weight() {return this.weight;}
	
	private ItemTagEntity[] tags;
	@Override public ItemTagEntity[] tags() {return this.tags;}
	
	private String description;
	@Override public String description() {return this.description;}
	
	private GenericItemEntity(
		String name,
		double price_value, String price_unit,
		double weight_value, String weight_unit,
		String[] tags,
		String description
	) {
		this(
			name,
			new Price(price_value, price_unit),
			new Weight(weight_value, weight_unit),
			Arrays.stream(tags).map(ItemTagEntity::new).toArray(ItemTagEntity[]::new),
			description
		);
	}
	private GenericItemEntity (
		String name, 
		Price price, 
		Weight weight, 
		ItemTagEntity[] tags, 
		String description
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
	}
	private GenericItemEntity(GenericItemData data) {
		this(
			data.name(),
			data.price_value(),
			data.price_unit(),
			data.weight_value(),
			data.weight_unit(),
			data.tags(),
			data.description()
		);
	}
	public GenericItemEntity(String name) {
		this ((GenericItemData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().generic_items, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public GenericItemEntity copy() {
		return new GenericItemEntity(
			this.name,
			this.price.value(),
			this.price.unit().name(),
			this.weight.value(),
			this.weight.unit().name(),
			Arrays.stream(this.tags).map(t -> t.name()).toArray(String[]::new),
			this.description
		);
	}
}
