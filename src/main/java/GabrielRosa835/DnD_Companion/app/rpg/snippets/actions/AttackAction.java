package app.rpg.snippets.actions;

import app.rpg.elements.actors.*;
import app.rpg.elements.options.*;
import app.rpg.elements.options.abilityScores.*;
import app.rpg.elements.options.weaponProperties.*;
import app.rpg.snippets.models.*;
import app.rpg.snippets.operations.*;
import co.unruly.control.result.*;
import lombok.*;

import static co.unruly.control.result.Introducers.*;
import static co.unruly.control.result.Transformers.*;
import static java.util.function.Function.identity;

@AllArgsConstructor
public class AttackAction
{
	public void act(
			CharacterActor source,
			CharacterActor target,
			WeaponOption weapon,
			Effect effect
	) {


		int attackRoll =
		return RollAbilityScoreTest.with(character, abilityScoreType).process()
		int D20Roll = RollDiceOperation.with("D20").process();
		return D20Roll + modifier;;
	}

	private CharacterActor target;
	private WeaponOption weapon;
	private Effect effect;

	private static Integer rollAttackWith(CharacterActor character, WeaponOption weapon) {

	}

	public <S, F> Result<S, F> perform(CharacterActor character) {
		var result = Result.success(character)
				.then(attempt(ifIs(c -> c.equipment().heldItems().containsValue(weapon), identity())))
				.then(attempt(ifIs(c -> c.inventory().content().containsKey(weapon), identity())))
				.then(onFailure(f -> "Character doesn't have such weapon"))
				.then(onSuccessDo(character::update))
				.then(onSuccess(c -> ))


//		return CharacterHasItemOnHandCheck.validateWith()
//				.orElseProcess(CharacterHasItemOnInventoryPredicate::test)
//				.orElseProcess(CharacterCanEquipItemPredicate::test)
//				.orElseProcess(EquipItemOnCharacterBiFunction.apply(character, item))
//				.then(character -> RollAttackWithWeaponBiFunction.apply(character, weaponOption))
//				.then((attack, defense) -> CompareAttackAndDefenseBiPredicate.test(attack, defense))
//				.then(character -> ApplyEffectBiFunction.apply(character, effect))
//				.onFailure(error -> {
//					// Handle failure case
//					System.out.println("An error occurred: " + error);
//					return Result.failure(error);
//				});
	}

	public enum Reasons {
		REASON1, REASON2, REASON3;
	}
}
