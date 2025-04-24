package app.rpg.snippets.models;

import app.common.functions.*;
import app.rpg.elements.actors.*;

@FunctionalInterface
public interface Action
	extends Operation<CharacterActor, CharacterActor>
{
	CharacterActor perform(CharacterActor character);

	@Override default CharacterActor process(CharacterActor character) {
		return perform(character);
	}
}
