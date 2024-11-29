package dnd_companion.local_storage.data_structure.java.items;

import dnd_companion.local_storage.data_structure.java.system.units.Price;
import dnd_companion.local_storage.data_structure.java.system.units.Weight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenericItem
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTag[] tags;
	private String description;
}
