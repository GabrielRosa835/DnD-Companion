package dnd_companion.game_helper.actors.entities.items;

import java.util.Arrays;

import dnd_companion.game_helper.actors.components.measures.Price;
import dnd_companion.game_helper.actors.components.measures.Weight;
import dnd_companion.game_helper.actors.models.ItemComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.AmmoData;
import dnd_companion.local_storage.tools.DataKey;

public class AmmoComponent implements ItemComponent
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
	
	private AmmoComponent (
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
	private AmmoComponent (
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
	private AmmoComponent(AmmoData data) {
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
	public AmmoComponent() {
		this(null, null, null, null, null);
	}
	public AmmoComponent(String name) {
		this(new AmmoComponent().retrieve(name));
	}
	
	@Override public AmmoData retrieve(String name) {
		return (AmmoData) new DataHandler()
				.retrieve(new DataKey(new AmmoData().collection(), name, AmmoData.class))
				.result();
	}
	@Override public AmmoComponent copy() {
		return new AmmoComponent(
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
