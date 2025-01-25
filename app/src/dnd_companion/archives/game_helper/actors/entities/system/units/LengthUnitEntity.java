package dnd_companion.archives.game_helper.actors.entities.system.units;

public class LengthUnitEntity implements Entity
{
	private String name;
	private String abbreviation;
	private Double normalizing_factor;

	public String name() {return this.name;}
	public String abbreviation() {return this.abbreviation;}
	public Double normalizing_factor() {return this.normalizing_factor;}

	public LengthUnitEntity name(String name) {
		this.name = name;
		return this;
	}
	public LengthUnitEntity abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public LengthUnitEntity normalizing_factor(Double normalizing_factor) {
		this.normalizing_factor = normalizing_factor;
		return this;
	}

	public LengthUnitEntity(String name, String abbreviation, Double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
}
