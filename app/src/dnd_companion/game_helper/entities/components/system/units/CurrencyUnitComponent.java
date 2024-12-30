package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.game_helper.entities.data.system.units.CurrencyUnitData;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.components.unit.UnitComponent;

public class CurrencyUnitComponent implements UnitComponent 
{
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
	public CurrencyUnitComponent() {
		this (null, null, 0);
	}
	public CurrencyUnitComponent(String name) {
		this (new CurrencyUnitComponent().retrieve(name));
	}
	
	@Override public CurrencyUnitData retrieve(String name) {
		return (CurrencyUnitData) new DataHandler()
				.retrieve(new DataKey(new CurrencyUnitData().collection(), name, CurrencyUnitData.class))
				.result();
	}
	@Override public CurrencyUnitComponent copy() {
		return new CurrencyUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
