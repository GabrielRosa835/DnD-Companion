package dnd_companion.entities.addons.models;

import java.util.List;

import dnd_companion.common.design_patterns.SimpleFactory;

public interface EntityFactory extends SimpleFactory 
{
	public List<Entity> dataList();
}
