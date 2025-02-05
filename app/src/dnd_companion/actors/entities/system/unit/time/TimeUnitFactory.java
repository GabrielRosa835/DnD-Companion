package dnd_companion.actors.entities.system.unit.time;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.entities.system.unit.time.data.Days;
import dnd_companion.actors.entities.system.unit.time.data.NormalTimeUnit;
import dnd_companion.actors.entities.system.unit.time.data.Hours;
import dnd_companion.actors.entities.system.unit.time.data.Minutes;
import dnd_companion.actors.entities.system.unit.time.data.Seconds;
import dnd_companion.actors.entities.system.unit.time.data.Weeks;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityFactory;

public class TimeUnitFactory implements EntityFactory
{
	TimeUnitFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(seconds(), minutes(), hours(), days(), weeks());
	}
	@Override public TimeUnitEntity defaultData() {
		return new NormalTimeUnit();
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
