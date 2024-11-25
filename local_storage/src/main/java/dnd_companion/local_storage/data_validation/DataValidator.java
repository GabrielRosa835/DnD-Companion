package dnd_companion.local_storage.data_validation;

import java.util.ArrayList;
import java.util.List;

import dnd_companion.local_storage.data.manipulation.ValueGroup;
import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class DataValidator 
{
	public static AtomicOption[] validate_options(AtomicOption... options) {
		try {
			List<AtomicOption> validated_options = new ArrayList<AtomicOption>();
			for (AtomicOption option : options) {
				validated_options.add((AtomicOption) new ValidateOptionCommand(option).execute().result());
			}
			return validated_options.toArray(new AtomicOption[validated_options.size()]);
		} catch (Exception e) {
			ToolBox.print_err(e);
			return null;
		}
	}
	public static AtomicUnit[] validate_units(String unit_group, String... units) {
		try {
			List<AtomicUnit> validated_units = new ArrayList<AtomicUnit>();
			for (String unit : units) {
				validated_units.add((AtomicUnit) new ValidateUnitOptionCommand(unit_group, unit).execute().result());
			}
			return validated_units.toArray(new AtomicUnit[validated_units.size()]);
		} catch (Exception e) {
			ToolBox.print_err(e);
			return null;
		}
	}
	public static ValueGroup[] validate_value_groups(ValueGroup... value_groups) {
		try {
			List<ValueGroup> validated_groups = new ArrayList<ValueGroup>();
			for (ValueGroup value_group : value_groups) {
				validated_groups.add((ValueGroup) new ValidateValueGroupsCommand(value_group).execute().result());
			}
			return validated_groups.toArray(new ValueGroup[validated_groups.size()]);			
		} catch (Exception e) {
			ToolBox.print_err(e);
			return null;
		}
	}
}
