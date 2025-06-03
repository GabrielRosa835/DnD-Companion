package app.domain.effects;

public interface ExtractedCharacterAttributes {

	public int initiative() {return 0;}
	public int armorClass() {return 0;}
	public int level() {return 0;}
	int hitDiceTotal;
	int hitDiceLeft;
	int proficiencyBonus;
	int attunementLimit;
}
