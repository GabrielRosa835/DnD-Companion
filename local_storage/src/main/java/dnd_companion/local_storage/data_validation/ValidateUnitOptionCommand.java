package dnd_companion.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class ValidateUnitOptionCommand extends DataValidatorCommand
{
	private String validated_unit;
	private AtomicUnit[] options;
	
	public ValidateUnitOptionCommand(String unit_group, String validated_unit) {
		super();
		this.validated_unit = validated_unit;
		this.options = (AtomicUnit[]) DataHandler.retrieve_units(unit_group);
	}
	
	public ValidateUnitOptionCommand execute() {
		Optional<AtomicUnit> unit_object = Arrays.stream(options)
				.filter(atom -> atom.name().equals(validated_unit) || atom.abbreviation().equals(validated_unit))
				.findFirst();
		if (unit_object.isPresent()) {
			this.message = String.format("Valid unit: %s", unit_object);
		} else {
			throw new InvalidOptionException(String.format("Not a valid unit: %s", unit_object));
		}
		this.result = unit_object.get();
		return this;
	}
}
