package dnd_companion.local_storage.data_structure.json.system;

import dnd_companion.local_storage.data_structure.json.templates.OptionData;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public record DiceTypeData (String... options)
implements OptionData<String>
{
	public DiceTypeData() {
		this(
			"D4",
			"D6",
			"D8",
			"D10",
			"D12",
			"D20"
		);
	}

	@Override
	public String collection() {return "system";}
	@Override
	public String file_name() {return "dice-types";}

	public DiceTypeData validate() throws InvalidOptionException{
		for (String s : this.options()) {
            if (!s.startsWith("D") || !s.substring(1).matches("\\d+")) {
                throw new InvalidOptionException("Invalid dice (" + s + ")");
            }
        }
		return this;
	}
}
