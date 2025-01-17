package dnd_companion.common.metadata;

import dnd_companion.archives.local_storage.structure.models.UnitData;

public class UnitREF 
{
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private String plural_name;
	public String plural_name() {return this.plural_name;}
	
	public UnitREF(String name, String abbreviation, String plural_name) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.plural_name = plural_name;
	}

	public UnitREF(UnitData data) {
		this(data.name(), data.abbreviation(), data.plural_name());
	}
}
