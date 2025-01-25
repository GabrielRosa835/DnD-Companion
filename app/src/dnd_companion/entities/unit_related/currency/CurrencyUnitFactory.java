package dnd_companion.entities.unit_related.currency;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.unit_related.currency.data.CopperPieces;
import dnd_companion.entities.unit_related.currency.data.DefaultCurrencyUnit;
import dnd_companion.entities.unit_related.currency.data.ElectrumPieces;
import dnd_companion.entities.unit_related.currency.data.GoldPieces;
import dnd_companion.entities.unit_related.currency.data.PlatinumPieces;
import dnd_companion.entities.unit_related.currency.data.SilverPieces;

public class CurrencyUnitFactory implements EntityFactory
{
	CurrencyUnitFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(copperPieces(), silverPieces(), electrumPieces(), goldPieces(), platinumPieces());
	}
	@Override public Entity defaultData() {
		return new DefaultCurrencyUnit();
	}

	public CurrencyUnitEntity copperPieces() {
		return new CopperPieces();
	}
	public CurrencyUnitEntity silverPieces() {
		return new SilverPieces();
	}
	public CurrencyUnitEntity electrumPieces() {
		return new ElectrumPieces();
	}
	public CurrencyUnitEntity goldPieces() {
		return new GoldPieces();
	}
	public CurrencyUnitEntity platinumPieces() {
		return new PlatinumPieces();
	}
}
