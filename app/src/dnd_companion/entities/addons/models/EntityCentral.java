package dnd_companion.entities.addons.models;

import dnd_companion.common.design_patterns.Facade;
import dnd_companion.common.metadata.Collections;

public interface EntityCentral extends Facade
{
	public EntityBuilder builder();
	public EntityFactory factory();
	public EntityScheme scheme();
	public Collections collection();
	public String path(String entity_name);
	public Entity retrieve(String entity_name);
}
