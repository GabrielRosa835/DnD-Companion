package dnd_companion.actors.entities.rules.damage_types;

import dnd_companion.actors.models.Entity;

public class DamageTypeEntity implements Entity
{
	private String name;
	
	@Override public String name() {return name;}
	
	protected DamageTypeEntity(String name) {
		this.name = name;
	}
	private DamageTypeEntity(DamageTypeEntity clone) {
		this.name = clone.name;
	}
	
	@Override public DamageTypeEntity clone() {
		return new DamageTypeEntity(this);
	}
	@Override public String toString() {
		return String.format("DamageType[name=%s]", name);
	}
}
