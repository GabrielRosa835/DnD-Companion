package dnd_companion.actors.entities.system.unit.currency;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.system.unit.currency.data.CopperPieces;
import dnd_companion.actors.entities.system.unit.currency.data.ElectrumPieces;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.currency.data.NormalCurrencyUnit;
import dnd_companion.actors.entities.system.unit.currency.data.PlatinumPieces;
import dnd_companion.actors.entities.system.unit.currency.data.SilverPieces;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class CurrencyUnitCentral implements EntityCentral
{
	private static CurrencyUnitCentral instance;
	private CurrencyUnitCentral() {}
	public static CurrencyUnitCentral use() {
		return instance == null? new CurrencyUnitCentral() : instance;
	}
	
	@Override public CurrencyUnitBuilder builder() {
		return new CurrencyUnitBuilder();
	}
	@Override public CurrencyUnitScheme scheme() {
		return new CurrencyUnitScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.CURRENCIES;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public CurrencyUnitEntity retrieve(String entity_name) {
		return (CurrencyUnitEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public CurrencyUnitEntity[] data() {
		return Arrays.asList(
				new NormalCurrencyUnit(),
				new CopperPieces(),
				new ElectrumPieces(),
				new GoldPieces(),
				new PlatinumPieces(),
				new SilverPieces())
				.toArray(CurrencyUnitEntity[]::new);
	}
}
