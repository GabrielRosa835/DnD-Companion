package dnd_companion.archives.game_helper.actors;

import dnd_companion.archives.game_helper.actors.builders.DamageTypeBuilder;
import dnd_companion.archives.game_helper.actors.builders.LengthUnitBuilder;

public class EntityFactory
{
	public LengthUnitBuilder length_unit() {return new LengthUnitBuilder();}
	public DamageTypeBuilder damage_type() {return new DamageTypeBuilder();}
}
