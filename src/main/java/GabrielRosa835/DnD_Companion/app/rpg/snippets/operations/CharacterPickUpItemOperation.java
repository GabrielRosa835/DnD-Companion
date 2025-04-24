package app.rpg.snippets.operations;

import app.common.functions.*;
import app.rpg.elements.actors.*;
import app.rpg.elements.models.types.*;
import app.rpg.snippets.checks.*;
import co.unruly.control.result.*;
import lombok.*;

import static co.unruly.control.result.Transformers.*;

@AllArgsConstructor (staticName = "with")
public class CharacterPickUpItemOperation
	implements Operation<CharacterActor, CharacterActor, CharacterPickUpItemOperation.FailureReasons>
{
	private final Item item;

	@Override public Result<
			CharacterActor,
			FailureReasons
	> process(CharacterActor character) {
		return Result.success(character, CharacterActor.class)
				.then(attempt(CharacterHasItemOnHandCheck.with(item)::validate))
				.then(invert())
				.then(attempt(CharacterPossessItemCheck.with(item)::validate))
				.then(onFailure(f -> FailureReasons.Reason2));
	}

	public enum FailureReasons {
		CHARACTER_ALREADY_HAS_ITEM_ON_HAND, Reason2
	}
}
