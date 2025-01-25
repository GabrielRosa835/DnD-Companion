package dnd_companion.archives.game_helper.actors.entities.system;

public class DamageTypeEntity implements Entity
{
	private String name;

	public String name() {return this.name;}

	public String name(String name) {
		this.name = name;
		return this.name;
	}

	public DamageTypeEntity(String name) {
		this.name = name;
	}
}
