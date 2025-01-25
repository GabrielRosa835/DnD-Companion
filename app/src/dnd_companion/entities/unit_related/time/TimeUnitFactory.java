package dnd_companion.entities.unit_related.time;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.unit_related.time.data.Days;
import dnd_companion.entities.unit_related.time.data.DefaultTimeUnit;
import dnd_companion.entities.unit_related.time.data.Hours;
import dnd_companion.entities.unit_related.time.data.Minutes;
import dnd_companion.entities.unit_related.time.data.Seconds;
import dnd_companion.entities.unit_related.time.data.Weeks;

public class TimeUnitFactory implements EntityFactory
{
	TimeUnitFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(seconds(), minutes(), hours(), days(), weeks());
	}
	@Override public TimeUnitEntity defaultData() {
		return new DefaultTimeUnit();
	}

	public TimeUnitEntity seconds() {
		return new Seconds();
	}
	public TimeUnitEntity minutes() {
		return new Minutes();
	}
	public TimeUnitEntity hours() {
		return new Hours();
	}
	public TimeUnitEntity days() {
		return new Days();
	}
	public TimeUnitEntity weeks() {
		return new Weeks();
	}
}
