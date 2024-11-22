package dnd_companion.game_helper.local_storage.data_validation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dnd_companion.game_helper.exceptions.InvalidOptionException;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.system_components.ResultCommand;

public class ValidateOptionUnitCommand extends ResultCommand
{
	private AtomicOptionUnit unit;
	private Atomic
	
	public ValidateOptionUnitCommand(AtomicOptionUnit unit) {
		this.unit = unit;
	}
	
	public ValidateOptionUnitCommand execute() {
		
		List<String> unit_names = Arrays.stream(unit_options())
				.map(atom -> atom.name())
				.collect(Collectors.toList());
		List<String> unit_abbreviations = Arrays.stream(unit_options())
				.map(atom -> atom.abbreviation())
				.collect(Collectors.toList());
		
		if (unit_names.contains(unit) || unit_abbreviations.contains(unit)) {
			Optional<AtomicOptionUnit> resultado = Arrays.stream(unit_options())
					.filter(atom -> atom.name().equals(unit) || atom.abbreviation().equals(unit))
					.findFirst();
			return resultado.orElseThrow(() -> new InvalidOptionException("Invalid measure unit"));
		} else {
			throw new InvalidOptionException("Invalid measure unit");
		}
	}
}
