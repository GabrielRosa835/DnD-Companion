package dnd_companion.game_helper.entities.components.items;

import java.util.Arrays;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.components.items.tags.ItemTagComponent;
import dnd_companion.game_helper.entities.data.items.GenericItemData;
import dnd_companion.game_helper.entities.elements.system.units.Price;
import dnd_companion.game_helper.entities.elements.system.units.Weight;
import dnd_companion.local_storage.structure.models.components.item.ItemComponent;

public class GenericItemComponent implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private Price price;
	@Override public Price price() {return this.price;}
	
	private Weight weight;
	@Override public Weight weight() {return this.weight;}
	
	private ItemTagComponent[] tags;
	@Override public ItemTagComponent[] tags() {return this.tags;}
	
	private String description;
	@Override public String description() {return this.description;}
	
	private GenericItemComponent (
		String name, 
		Price price, 
		Weight weight, 
		ItemTagComponent[] tags, 
		String description
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
	}
	private GenericItemComponent(
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
			Arrays.stream(tags).map(ItemTagComponent::new).toArray(ItemTagComponent[]::new),
			description
		);
	}
	private GenericItemComponent(GenericItemData data) {
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
	public GenericItemComponent() {
		this(null, null, null, null, null);
	}
	public GenericItemComponent(String name) {
		this(new GenericItemComponent().retrieve(name));
	}
	
	@Override public GenericItemData retrieve(String name) {
		return (GenericItemData) new DataHandler()
				.retrieve(new DataKey(new GenericItemData().collection(), name, GenericItemData.class))
				.result();
	}
	@Override public GenericItemComponent copy() {
		return new GenericItemComponent(
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
