package dnd_companion.game_helper.actors.entities.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.metadata.UnitsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.actors.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.units.WeightUnitData;

public class WeightUnitEntity implements UnitComponent 
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
	private WeightUnitEntity(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	
	// Data Constructor
	private WeightUnitEntity(WeightUnitData data) {
		this(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	
	// Naming Constructor
	public WeightUnitEntity(String name) {
		this ((WeightUnitData) handler
				.retrieve(collections.weight_units(), tools.to_file_name(units.get_name(name)))
				.result());
	}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Method that creates a new and non-referenced component
	 */
	@Override public WeightUnitEntity copy() {
		return new WeightUnitEntity(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
 // ===============================================================================
}
