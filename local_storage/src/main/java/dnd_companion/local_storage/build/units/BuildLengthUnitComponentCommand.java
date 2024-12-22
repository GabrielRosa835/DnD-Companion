package dnd_companion.local_storage.build.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.exceptions.InvalidDataException;
import dnd_companion.local_storage.models.common.Command;
import dnd_companion.local_storage.structure.components.system.units.length.LengthUnitComponent;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.validation.DataValidator;

public class BuildLengthUnitComponentCommand extends Command<LengthUnitComponent>
{
	private final LengthUnitData data;
	private final DataKey key;

	public BuildLengthUnitComponentCommand(LengthUnitData data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = "Failed to build length unit component: " + key.toString();
	}
	
	@Override public void code() throws InvalidDataException {
		if (!new DataValidator().validate(this.data).status()) {
			throw new InvalidDataException("Invalid length unit: " + key.toString());
		}
		LengthUnitComponent component = new LengthUnitComponent(
				data.name(),
				data.abbreviation(),
				data.normalizing_factor());
		this.result = component;
		this.message = "Length unit's build was successful: " + key.toString();
	}
}
