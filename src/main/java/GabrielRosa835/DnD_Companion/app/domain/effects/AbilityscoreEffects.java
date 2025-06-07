package app.domain.effects;

public interface AbilityScoreEffects {
	static int calculateModifier (int value) {
		return (int) Math.floor(value / 3.0) - 5;
	}
}
