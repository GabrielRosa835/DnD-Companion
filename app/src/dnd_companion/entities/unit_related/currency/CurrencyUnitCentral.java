package dnd_companion.entities.unit_related.currency;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.DataHandler;

public class CurrencyUnitCentral implements EntityCentral
{
	@Override public Class<? extends Entity> type() {
		return CurrencyUnitEntity.class;
	}
	@Override public CurrencyUnitBuilder builder() {
		return new CurrencyUnitBuilder();
	}
	@Override public CurrencyUnitFactory factory() {
		return new CurrencyUnitFactory();
	}
	@Override public CurrencyUnitScheme scheme() {
		return new CurrencyUnitScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().currencies();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public CurrencyUnitEntity retrieve(String entity_name) {
		return (CurrencyUnitEntity) new DataHandler()
				.retrieve(this, entity_name)
				.get();
	}
}
