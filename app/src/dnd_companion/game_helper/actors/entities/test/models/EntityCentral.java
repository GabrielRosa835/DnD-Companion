package dnd_companion.game_helper.actors.entities.test.models;

import dnd_companion.common.metadata.CollectionREF;

public interface EntityCentral
{
	public Class<? extends Entity> type();
	public EntityBuilder builder();
	public EntityFactory factory();
	public EntityJsonScheme scheme();
	public CollectionREF collection();
	public String path(String entity_name);
}
