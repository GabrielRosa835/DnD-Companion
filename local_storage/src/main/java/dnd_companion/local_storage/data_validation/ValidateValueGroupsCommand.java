package dnd_companion.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data.manipulation.ValueGroup;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class ValidateValueGroupsCommand extends DataValidatorCommand
{
	private ValueGroup validated_value_group;
	private AtomicUnit[] unit_options;

	public ValidateValueGroupsCommand(ValueGroup validated_value_group) {
		this.validated_value_group = validated_value_group;
		this.unit_options = (AtomicUnit[]) DataHandler.retrieve_options(validated_value_group.unit_group());
	}

	public ValidateValueGroupsCommand execute() {
		Optional<AtomicUnit> unit_object = Arrays.stream(unit_options)
				.filter(atom -> atom.name().equals(validated_value_group.unit().name()))
				.findFirst();
		if (unit_object.isPresent()) {
			this.message = String.format("Valid group-value option: %s", validated_value_group);
		} else {
			throw new InvalidOptionException(String.format("Not a valid group-value option: %s", validated_value_group));
		}
		this.result = unit_object.get();
		return this;
	}
}
