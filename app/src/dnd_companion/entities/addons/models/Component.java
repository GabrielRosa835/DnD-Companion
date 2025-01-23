package dnd_companion.entities.addons.models;

import dnd_companion.common.design_patterns.Prototype;

public interface Component extends Prototype
{
	public Component clone();
	@Override public String toString();
}
