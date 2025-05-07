package app.domain.effects;

public interface DiceEffects
{

	static int getMaxValueFromName (String name) {
		if (name == null || !name.matches("D\\d+")) {
			throw new IllegalArgumentException("Not a valid dice:" + name);
		}
		return Integer.parseInt(name.substring(1));
	}

}
