package dnd_companion.entities.unit_related.currency;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class CurrencyUnitCentral implements EntityCentral
{
	@Override public CurrencyUnitBuilder builder() {
		return new CurrencyUnitBuilder();
	}
	@Override public CurrencyUnitFactory factory() {
		return new CurrencyUnitFactory();
	}
	@Override public CurrencyUnitScheme scheme() {
		return new CurrencyUnitScheme();
	}
	@Override public Collections collection() {
		return Collections.CURRENCIES;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public CurrencyUnitEntity retrieve(String entity_name) {
		return (CurrencyUnitEntity) DataHandler.retrieve(this, entity_name);
	}
}
