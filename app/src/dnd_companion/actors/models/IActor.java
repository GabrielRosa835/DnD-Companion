package dnd_companion.actors.models;

import dnd_companion.common.design_patterns.Prototype;

public interface IActor extends Prototype
{
	public IActor clone();
	@Override public String toString();
}
