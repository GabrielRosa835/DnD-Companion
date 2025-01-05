package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.local_storage.tools.DataKey;

public class LengthUnitComponent implements UnitComponent 
{
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private LengthUnitComponent(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	private LengthUnitComponent(LengthUnitData data) {
		this(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	public LengthUnitComponent(String name) {
		this ((LengthUnitData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().length_units, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public LengthUnitComponent copy() {
		return new LengthUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
