package dnd_companion.game_helper.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.game_helper.exceptions.InvalidOptionException;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handling.DataHandler;

public class ValidateGroupValueCommand extends DataValidatorCommand
{
	private GroupValue validated_group_value;
	
	private AtomicOptionUnit[] unit_options = (AtomicOptionUnit[]) DataHandler.retrieve_options(validated_group_value.unit_group());

	public ValidateGroupValueCommand(GroupValue validated_group_value) {
		this.validated_group_value = validated_group_value;
	}

	public ValidateGroupValueCommand execute() {
		Optional<AtomicOptionUnit> unit_object = Arrays.stream(unit_options)
				.filter(atom -> atom.name().equals(validated_group_value.unit().name()))
				.findFirst();
		if (unit_object.isPresent()) {
			this.message = String.format("Valid group-value option: %s", validated_group_value);
		} else {
			throw new InvalidOptionException(String.format("Not a valid group-value option: %s", validated_group_value));
		}
		this.result = validated_group_value;
		return this;
	}
}
