package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.metadata.UnitsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.units.WeightUnitData;

public class WeightUnitComponent implements UnitComponent 
{
 // ===============================================================================
	/*
	 * Dependencies' Injections
	 */
	private static DataHandler handler = new DataHandler();
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static UnitsMetadata units = new UnitsMetadata();
	private static ToolBox tools = new ToolBox();
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Attributes definitions and their getters
	 */
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Component Constructors
	 */
	
	// Primitive Constructor
	private WeightUnitComponent(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	
	// Data Constructor
	private WeightUnitComponent(WeightUnitData data) {
		this(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	
	// Naming Constructor
	public WeightUnitComponent(String name) {
		this ((WeightUnitData) handler
				.retrieve(collections.weight_units(), tools.to_file_name(units.get_name(name)))
				.result());
	}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Method that creates a new and non-referenced component
	 */
	@Override public WeightUnitComponent copy() {
		return new WeightUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
 // ===============================================================================
}
