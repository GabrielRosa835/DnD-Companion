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

	@Override
	public ValidateOptionCommand<T> execute() {
		try {
			Optional<T> optional = Arrays.stream(options)
					.filter(o -> o.equals(validated_option))
					.findFirst();
			if (optional.isEmpty()) {
				throw new InvalidOptionException("Not a valid option (" + optional.toString() + ")");
			}
			this.result = optional.get();
			this.status = true;
			this.message = "Option validated successfully: " + this.result.toString();
		} catch (Exception e) {
			this.result = null;
			this.status = false;
			this.message = "Something went wrong while validating option";
			e.printStackTrace();
		}
		return this;
	}
}
