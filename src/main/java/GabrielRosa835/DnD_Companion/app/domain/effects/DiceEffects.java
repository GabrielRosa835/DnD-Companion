package app.domain.effects;

public interface DiceEffects
{



	public int roll() {
		return (int) ((maxValue - 1) * Math.random()) + 1;
	}

}
