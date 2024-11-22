package dnd_companion.game_helper.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.game_helper.exceptions.InvalidOptionException;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handling.DataHandler;

public class ValidateUnitCommand extends DataValidatorCommand
{
	private String validated_unit;
	private String unit_group;
	
	private AtomicOptionUnit[] options = (AtomicOptionUnit[]) DataHandler.retrieve_options(unit_group);
	
	public ValidateUnitCommand(String validated_unit, String unit_group) {
		super();
		this.validated_unit = validated_unit;
		this.unit_group = unit_group;
	}
	
	public ValidateUnitCommand execute() {
		Optional<AtomicOptionUnit> unit_object = Arrays.stream(options)
				.filter(atom -> atom.name().equals(validated_unit) || atom.abbreviation().equals(validated_unit))
				.findFirst();
		if (unit_object.isPresent()) {
			this.message = String.format("Valid unit: %s", unit_object);
		} else {
			throw new InvalidOptionException(String.format("Not a valid unit: %s", unit_object));
		}
		this.result = unit_object;
		return this;
	}
}
