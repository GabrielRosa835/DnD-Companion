package dnd_companion.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class ValidateOptionCommand<T> extends Command
{
	private T validated_option;
	private T[] options;
	
	private T result;
	public T result() {return this.result;}

	public ValidateOptionCommand(DataKey key, T validated_option) {
		super();
		this.options = DataHandler.retrieve_options(key);
		this.validated_option = validated_option;
	}

	public ValidateOptionCommand<T> execute() {
		Optional<T> optional = Arrays.stream(options)
				.filter(o -> o.equals(validated_option))
				.findFirst();
		if (!optional.isPresent()) {
			throw new InvalidOptionException(String.format("Not a valid option: %s", optional.toString()));
		}
		this.result = optional.get();
		return this;
	}
}
