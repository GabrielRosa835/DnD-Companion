package app.storage;

import app.rpg.elements.models.IEntity;

public interface Collection<Entity extends IEntity> {
	String name();

	Class<Entity> type();
}
