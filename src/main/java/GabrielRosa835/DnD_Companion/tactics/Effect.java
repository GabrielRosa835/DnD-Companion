package tactics;

public interface Effect extends Tactic
{
	@Override Effect execute();
	Effect target(Applicable target);

	interface Applicable {
		Applicable applyEffect(Effect effect);
	}
}
