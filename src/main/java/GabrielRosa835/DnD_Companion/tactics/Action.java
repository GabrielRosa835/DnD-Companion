package tactics;

public interface Action extends Tactic
{
	@Override Action execute();
	Action source(Applicable applicable);
	Action targets(Effect.Applicable... targets);
	Action effect(Effect effect);

	interface Applicable
	{
		public Action actWith(Action action);
	}
}
