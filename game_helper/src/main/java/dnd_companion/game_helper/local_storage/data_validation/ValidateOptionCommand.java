package dnd_companion.game_helper.local_storage.data_validation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dnd_companion.game_helper.exceptions.InvalidOptionException;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handler.DataHandler;
import dnd_companion.game_helper.local_storage.system_components.ResultCommand;

public class ValidateOptionCommand extends ResultCommand
{
	private AtomicOption validated_option;
	private String options_name;
	
	private AtomicOption[] options = DataHandler.retrieve_options(options_name);

	public ValidateOptionCommand(AtomicOption validated_option, String options_name) {
		this.validated_option = validated_option;
		this.options_name = options_name;
	}

	public ValidateOptionCommand execute() {
		
		List<AtomicOption> option_objects = Arrays.asList(options);
		
		if (option_objects.contains(validated_option)) {
			this.result = validated_option;
		} else {
			throw new InvalidOptionException("Invalid measure unit");
		}
		
	}
}
