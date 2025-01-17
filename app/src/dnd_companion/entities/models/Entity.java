package dnd_companion.entities.models;

import dnd_companion.common.design_patterns.Prototype;

public interface Entity extends Prototype
{
	public String name();
	public Entity clone();
	@Override public String toString();
}
