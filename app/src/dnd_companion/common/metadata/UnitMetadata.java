package dnd_companion.common.metadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.UnitData;
import dnd_companion.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.local_storage.structure.system.units.WeightUnitData;
import dnd_companion.local_storage.tools.DataKey;

public abstract class UnitMetadata 
{
	public static final HashMap<String, MetadataGroup> name_abbreviations = new HashMap<>();
	
	private static void add(String name, String abbreviation, String plural_name) {
		name_abbreviations.put(name, new MetadataGroup(name, abbreviation, plural_name));
		name_abbreviations.put(abbreviation, new MetadataGroup(name, abbreviation, plural_name));
		name_abbreviations.put(plural_name, new MetadataGroup(name, abbreviation, plural_name));
	}
	
	public static String get_name(String value) {
		return name_abbreviations.get(value).name();
	}
	public static String get_abbreviation(String value) {
		return name_abbreviations.get(value).abbreviation();
	}
	public static String get_plural_name(String value) {
		return name_abbreviations.get(value).plural_name();
	}
	
	static {
		DataHandler handler = new DataHandler();
		ArrayList<UnitData[]> collection = new ArrayList<UnitData[]>(Arrays.asList(
			(UnitData[]) handler.retrieve_multiple(Collections.currencies, CurrencyUnitData.class).result(),
			(UnitData[]) handler.retrieve_multiple(new DataKey(new LengthUnitData())).result(),
			(UnitData[]) handler.retrieve_multiple(new DataKey(new TimeUnitData())).result(),
			(UnitData[]) handler.retrieve_multiple(new DataKey(new WeightUnitData())).result()
		));
		for (UnitData[] units : collection) {
			for (UnitData unit : units) {
				add(unit.name(), unit.abbreviation(), unit.plural_name());
			}
		}		
	}
	
	public record MetadataGroup (String name, String abbreviation, String plural_name) {}
}














