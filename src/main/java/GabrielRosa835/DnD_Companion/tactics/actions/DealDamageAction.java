package tactics.actions;

import tactics.*;
import tactics.effects.*;

public class DealDamageAction extends Action
{
	private Effect effect = new SimpleDamageDealEffect();

	@Override
	public Action execute() {
		return null;
	}

	@Override
	public Action source(Applicable applicable) {
		return null;
	}

	@Override
	public Action timing(Timing timing) {
		return null;
	}

	@Override
	public Action targets(Effect.Applicable... applicables) {
		return null;
	}
}
