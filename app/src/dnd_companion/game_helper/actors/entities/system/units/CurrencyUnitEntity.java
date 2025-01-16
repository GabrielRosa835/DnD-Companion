package dnd_companion.game_helper.actors.entities.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.actors.models.Component;
import dnd_companion.game_helper.actors.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.local_storage.tools.DataKey;

public class CurrencyUnitEntity implements UnitComponent 
{
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private CurrencyUnitEntity(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	private CurrencyUnitEntity(CurrencyUnitData data) {
		this (data.name(), data.abbreviation(), data.normalizing_factor());
	}
	private CurrencyUnitEntity(String name) {
		this ((CurrencyUnitData) new DataHandler()
				.retrieve(new DataKey(
						collections.currencies(), 
						tools.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public CurrencyUnitEntity buildNull() {
		return new CurrencyUnitEntity(null, null, 0);
	}
	@Override public CurrencyUnitEntity buildByName(String name) {
		return new CurrencyUnitEntity(name);
	}
	@Override public CurrencyUnitEntity buildByData(Data data) {
		return new CurrencyUnitEntity((CurrencyUnitData) data);
	}
	@Override public CurrencyUnitEntity copy() {
		return new CurrencyUnitEntity(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
