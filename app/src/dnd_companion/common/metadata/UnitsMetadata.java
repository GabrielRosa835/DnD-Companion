package dnd_companion.common.metadata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.UnitData;

public class UnitsMetadata 
{
	private final CollectionsMetadata collections = new CollectionsMetadata();
	private final DataHandler handler = new DataHandler();
	
	private HashMap<String, UnitREF> map = new HashMap<>();
	public HashMap<String, UnitREF> map() {return this.map;}
	
	
	public UnitsMetadata() {
		List<UnitData> units = Arrays.stream(collections.all())
				.filter(collection -> collection.parent().equals(collections.units))
				.map(collection -> handler.retrieve_multiple(collection).result())
				.flatMap(Arrays::stream)
				.map(data -> (UnitData) data)
				.collect(Collectors.toList());
		for (UnitData unit : units) {
			this.add(unit);
		}
	}
	
	public String get_name(String key) {
		return map.get(key).name();
	}
	public String get_abbreviation(String key) {
		return map.get(key).abbreviation();
	}
	public String get_plural_name(String key) {
		return map.get(key).plural_name();
	}
	
	public void add(UnitData data) {
		map.put(data.name(),         new UnitREF(data.name(), data.abbreviation(), data.plural_name()));
		map.put(data.abbreviation(), new UnitREF(data.name(), data.abbreviation(), data.plural_name()));
		map.put(data.plural_name(),  new UnitREF(data.name(), data.abbreviation(), data.plural_name()));
	}
}














