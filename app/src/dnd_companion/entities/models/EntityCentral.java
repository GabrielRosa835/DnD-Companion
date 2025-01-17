package dnd_companion.entities.models;

import dnd_companion.common.design_patterns.Singleton;
import dnd_companion.common.metadata.CollectionREF;

public interface EntityCentral extends Singleton
{
	public Class<? extends Entity> type();
	public EntityBuilder builder();
	public EntityFactory factory();
	public EntityScheme scheme();
	public CollectionREF collection();
	public String path(String entity_name);
}
