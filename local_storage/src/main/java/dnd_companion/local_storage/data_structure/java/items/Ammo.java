package dnd_companion.local_storage.data_structure.java.items;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.data_structure.java.system.units.Price;
import dnd_companion.local_storage.data_structure.java.system.units.Weight;
import dnd_companion.local_storage.data_structure.json.atomic.AmmoType;
import dnd_companion.local_storage.data_structure.json.items.weapons.AmmoTypeData;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Ammo extends GenericItem
{
	public Ammo retrieve(String name) throws InvalidOptionException {
		AmmoType[] options = DataHandler.retrieve_options(new DataKey(AmmoTypeData.class));
		Optional<AmmoType> option = Arrays.stream(options).filter(o -> o.name().equals(name)).findFirst();
		if (option.isEmpty()) {
			throw new InvalidOptionException("Invalid ammo name (" + name + ")");
		}
		AmmoType ammo = option.get();
		return new Ammo(
			ammo.name(),
			new Price(ammo.price_value(), ammo.price_unit()),
			new Weight(ammo.weight_value(), ammo.weight_unit()),
			new ItemTag[]{new ItemTag("Ammo")},
			ammo.description()
		);
	}
}
