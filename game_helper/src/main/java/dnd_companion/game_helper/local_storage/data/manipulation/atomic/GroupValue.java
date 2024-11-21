package dnd_companion.game_helper.local_storage.data.manipulation.atomic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dnd_companion.game_helper.exceptions.InvalidOptionException;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;

public abstract class GroupValue
{
	private double value;
	public double value() {return this.value;}
	
	private AtomicOptionUnit unit;
	public AtomicOptionUnit unit() {return this.unit;}
	
	protected abstract AtomicOptionUnit[] unit_options();
	
	public GroupValue(double value, String unit) {
		this.value = value;
		this.unit = validate_unit(unit);
	}

	public GroupValue convert_to(String unit) {
		AtomicOptionUnit validated_unit = this.validate_unit(unit);
		this.unit = validated_unit;
		this.value = this.normalized_value() / validated_unit.normalizing_factor();
		return this;
	}

	public double normalized_value() {
		return this.value * this.unit.normalizing_factor();
	}
	
	protected AtomicOptionUnit validate_unit(String unit) {
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
