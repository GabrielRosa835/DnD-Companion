package dnd_companion.game_helper.local_storage.data_validation;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;

public class DataValidator 
{
	public static AtomicOption validate_option(AtomicOption option) {
		return (AtomicOption) new ValidateOptionCommand(option).execute().result();
	}
	public static AtomicOptionUnit validate_unit(String unit, String unit_group) {
		return (AtomicOptionUnit) new ValidateUnitCommand(unit, unit_group).execute().result();
	}
	public static GroupValue validate_group_value(GroupValue group_value) {
		return (GroupValue) new ValidateGroupValueCommand(group_value).execute().result();
	}
}
