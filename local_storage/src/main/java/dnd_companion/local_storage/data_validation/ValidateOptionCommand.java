package dnd_companion.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class ValidateOptionCommand extends DataValidatorCommand
{
	private AtomicOption validated_option;
	private AtomicOption[] options;

	public ValidateOptionCommand(AtomicOption validated_option) {
		super();
		this.validated_option = validated_option;
		this.options = DataHandler.retrieve_options(validated_option.group());
	}

	public ValidateOptionCommand execute() {
		Optional<AtomicOption> option_object = Arrays.stream(options)
				.filter(atom -> atom.equals(validated_option))
				.findFirst();
		if (option_object.isPresent()) {
			this.message = String.format("Valid option: %s", option_object.toString());
		} else {
			throw new InvalidOptionException(String.format("Not a valid option: %s", option_object.toString()));
		}
		this.result = option_object.get();
		return this;
	}
}
