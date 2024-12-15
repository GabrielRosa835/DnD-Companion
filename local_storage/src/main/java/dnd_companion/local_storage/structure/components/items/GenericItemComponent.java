package dnd_companion.local_storage.structure.components.items;

import java.util.Arrays;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.ItemComponent;
import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.components.system.units.PriceComponent;
import dnd_companion.local_storage.structure.components.system.units.WeightComponent;
import dnd_companion.local_storage.structure.data.items.GenericItemData;

public class GenericItemComponent implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private PriceComponent price;
	@Override public PriceComponent price() {return this.price;}
	
	private WeightComponent weight;
	@Override public WeightComponent weight() {return this.weight;}
	
	private ItemTagComponent[] tags;
	@Override public ItemTagComponent[] tags() {return this.tags;}
	
	private String description;
	@Override public String description() {return this.description;}
	
	public GenericItemComponent(String name) {
		GenericItemData data = (GenericItemData) new DataHandler()
				.retrieve(new DataKey(new GenericItemData().collection(), name, GenericItemData.class))
				.result();
		this.name = data.name();
		this.price = new PriceComponent(data.price_value(), data.price_unit());
		this.weight = new WeightComponent(data.weight_value(), data.weight_unit());
		this.tags = Arrays.stream(data.tags())
				.map(ItemTagComponent::new)
				.toArray(ItemTagComponent[]::new);
		this.description = data.description();
	}
}
