package tactics.actions;

import elements.entities.Character;
import lombok.AllArgsConstructor;
import tactics.*;
import tactics.effects.*;

import java.util.List;

public class DealDamageAction implements Action<Character>
{
	private SimpleDamageDealEffect effect;
	public DealDamageAction effect(int damage) {
		this.effect = new SimpleDamageDealEffect(damage);
		return this;
	}

	public DealDamageAction(int damage) {
		this.effect = new SimpleDamageDealEffect(damage);
	}

	@Override public void act (List<Character> characters) {
		for (Character character : characters) {
			character.health().applyEffect(effect);
		}
	}
}
