package dnd_companion.actors.models;

import dnd_companion.common.design_patterns.Prototype;

public interface Actor extends Prototype
{
	public Actor clone();
	@Override public String toString();
}
