package app.domain.effects;

public interface ProficiencyEffects {

	static int calculateProficiencyBonus(int totalLevel) {
		return (int) (Math.ceil(totalLevel / 4.0) + 1);
	}

}
