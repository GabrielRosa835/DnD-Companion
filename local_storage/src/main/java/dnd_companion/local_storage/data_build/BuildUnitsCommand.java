package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.structure.UnitData;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class BuildUnitsCommand extends DataBuilderCommand
{
	private AtomicUnit[] units;
	
	public BuildUnitsCommand(AtomicUnit[] units) {
		super();
		this.units = units;
	}

	public BuildUnitsCommand execute() {
		try {
			UnitData data = new UnitData(
				this.units[0].group(),
				this.units
			);			
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
