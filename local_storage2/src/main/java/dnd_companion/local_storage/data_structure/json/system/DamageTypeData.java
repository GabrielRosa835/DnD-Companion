package dnd_companion.local_storage.data_structure.json.system;

import dnd_companion.local_storage.data_structure.json.templates.OptionData;

public record DamageTypeData (String... options)
implements OptionData<String>
{
	public DamageTypeData() {
		this(
			"Acid",
			"Bludgeoning",
			"Cold",
			"Fire",
			"Force",
			"Lightning",
			"Necrotic",
			"Piercing",
			"Poison",
			"Psychic",
			"Radiant",
			"Slashing",
			"Thunder"
		);
	}

	@Override
	public String collection() {return "system";}
	@Override
	public String file_name() {return "damage-types";}
}
