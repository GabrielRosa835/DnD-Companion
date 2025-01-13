package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.game_helper.entities.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.local_storage.tools.DataKey;

public class CurrencyUnitComponent implements UnitComponent 
{
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private CurrencyUnitComponent(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	private CurrencyUnitComponent(CurrencyUnitData data) {
		this (data.name(), data.abbreviation(), data.normalizing_factor());
	}
	private CurrencyUnitComponent(String name) {
		this ((CurrencyUnitData) new DataHandler()
				.retrieve(new DataKey(
						collections.currencies(), 
						tools.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public CurrencyUnitComponent buildNull() {
		return new CurrencyUnitComponent(null, null, 0);
	}
	@Override public CurrencyUnitComponent buildByName(String name) {
		return new CurrencyUnitComponent(name);
	}
	@Override public CurrencyUnitComponent buildByData(Data data) {
		return new CurrencyUnitComponent((CurrencyUnitData) data);
	}
	@Override public CurrencyUnitComponent copy() {
		return new CurrencyUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
